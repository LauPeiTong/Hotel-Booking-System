package com.catravel.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.catravel.repository.*;
import com.catravel.service.*;
import com.catravel.model.*;

@Controller
@RequestMapping("/hotels")
public class HotelController {
	private final HotelRepository hotelRepository;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BookingRoomRepository bookingRoomRepository;
	
	@Autowired
	private RoomTypeRepository roomTypeRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	public HotelController(HotelRepository hotelRepository) {
		this.hotelRepository = hotelRepository;
	}
	
	
	
	/**
	 * show index
	 */
	@GetMapping("home")
	public String index() {	
		return "index";
	}
	
	
	
	/**
	 * change hotel
	 */
	@GetMapping("changeHotel")
	public String changeHotel(Model model, HttpServletRequest request) {
		List<Hotel> hotels = (List<Hotel>) request.getSession().getAttribute("hotels");
		
		if(hotels.isEmpty()) {
			List<Hotel> allHotels = hotelRepository.findAll();
			model.addAttribute("allHotels", allHotels);
		}
		
		model.addAttribute("inputDestination", request.getSession().getAttribute("inputDestination"));
		model.addAttribute("hotels", hotels);
		
		return "search-hotel";
	}
	
	
	
	/**
	 * serach
	 */
	@GetMapping("search")
	public String searchHotel(Model model, @Param("keyword") String inputDestination, String checkInDate, 
			Integer duration, String checkOutDate, Integer noOfGuest, Integer noOfRoom, HttpSession session) throws ParseException {
		List<Hotel> hotels = hotelService.listAll(inputDestination);
		
		//if there is no hotel matched with inputDestination
		//'all hotels' is used to displayed all the hotels
		if(hotels.isEmpty()) {
			List<Hotel> allHotels = hotelRepository.findAll();
			model.addAttribute("allHotels", allHotels);
		}
		
		model.addAttribute("hotels", hotels);
		model.addAttribute("inputDestination", inputDestination);
		session.setAttribute("hotels", hotels);
		session.setAttribute("inputDestination", inputDestination);
		
		//for passing the value of booking details
		session.setAttribute("checkInDate", checkInDate);
		session.setAttribute("checkOutDate", checkOutDate);
		session.setAttribute("duration", duration);
		session.setAttribute("noOfGuest", noOfGuest);
		session.setAttribute("noOfRoom", noOfRoom);
		
		return "search-hotel";
	}
	
	
	
	/**
	 * choose room
	 */
	@GetMapping("chooseHotel/{hotelid}")
	public String showHotelDetails(@PathVariable("hotelid") long id, Model model, HttpServletRequest request, HttpSession session) throws ParseException {
		Hotel hotel = hotelRepository.findById((int) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid hotel Id: " + id));

		List<RoomType> roomTypes = roomTypeRepository.findAllByHotelId((int) id);
		
		LocalDate checkInDate = stringToDate((String) request.getSession().getAttribute("checkInDate"));
		LocalDate checkOutDate = stringToDate((String) request.getSession().getAttribute("checkOutDate"));
		int noOfRoom = (int) request.getSession().getAttribute("noOfRoom");

		//for checking the room type is available or not
		for(int i = 0; i < roomTypes.size(); i++) {
			int roomTypeId = roomTypes.get(i).getRoomTypeId();
			int n = bookingRoomRepository.countNoOfRoomNoAvailable(roomTypeId, checkInDate, checkOutDate);
			int noOfRoomAvailable = roomTypes.get(i).getNoOfRoom() - n;
			
			System.out.println(noOfRoomAvailable + "******************************");
			
			if(noOfRoomAvailable < noOfRoom){
				roomTypes.get(i).setAvailable(false);
			}
			else {
				roomTypes.get(i).setAvailable(true);
			}	
		}
 		
		//show hotel details and room types
		session.setAttribute("hotel", hotel);
		
		model.addAttribute("hotel", hotel);
		model.addAttribute("roomTypes", roomTypes);
		
		//update the room type (boolean isAvailable)
		roomTypeRepository.saveAll(roomTypes);
		
		return "hotel-details";
	}
	
	
	
	/**
	 * show payment
	 * @throws ParseException 
	 */
	@GetMapping("chooseRoom/{roomtypeid}")
	public String showPayment(@PathVariable("roomtypeid") long id, HttpSession session) throws ParseException {
		loadPaymentDetails((int) id, session);
		
		return "payment";
	}
	
	
	
	/**
	 * login
	 */
	@GetMapping("login")
	public String showLoginPage(HttpSession session, HttpServletRequest request) {
		session.setAttribute("isChooseRoom", getPreviousPageByRequest(request).orElse("/").contains("chooseRoom")); 

		return "login";
	}
	
	@PostMapping("loginUser")
	public String loginToPayment(Model model, String email, String password, HttpSession session) {
		// if customer is admin
		if(email.contains("catravel.com")) {
			Admin admin = adminRepository.findByEmailAndPassword(email, password);
			
			if(admin != null) {
				session.setAttribute("admin", admin);
				session.setAttribute("isAdmin", true);
				
				List<Booking> bookings = bookingRepository.findAll();
				List<Customer> customers = customerRepository.findAll();
				List<Hotel> hotels = hotelRepository.findAll();

				model.addAttribute("bookings", bookings);
				model.addAttribute("customers", customers);
				model.addAttribute("hotels", hotels);
				return "update";
			}
		}
		
		//if the customer is not admin
		Customer customer = customerRepository.findByEmailAndPassword(email, password);
		
		if(customer == null) {
			model.addAttribute("loginFail", true);
			return "login";
		}
		
		session.setAttribute("customer", customer);
		session.setAttribute("isLogin", true);
		
		if((boolean) session.getAttribute("isChooseRoom")) {			
			return "payment";
		}
		else {
			return "index";
		}
		
	}
	
	
	/**
	 * pay
	 */
	@PostMapping("pay")
	public String confirmBooking(Model model, HttpServletRequest request) {
		List<Room> rooms = (List<Room>) request.getSession().getAttribute("rooms");
		Booking booking = (Booking) request.getSession().getAttribute("booking");
		Payment payment = (Payment) request.getSession().getAttribute("payment");
		Customer customer = (Customer) request.getSession().getAttribute("customer");

		
		booking.setCustomer(customer);
		bookingRepository.save(booking);
		
		payment.setBooking(booking);
		paymentRepository.save(payment);
		
		for(int i = 0; i < rooms.size(); i++) {
			BookingRoom bookingRoom = new BookingRoom(booking, rooms.get(i));
			bookingRoomRepository.save(bookingRoom);
		}
				
		return "payment-confirm";
	}
	
	
	
	/**
	 * logout
	 */
	@GetMapping("logout")
	public String logout(HttpSession session, HttpServletRequest request) {
		session.setAttribute("isLogin", false);
		session.setAttribute("isAdmin", false);
		session.setAttribute("customer", null);
		session.setAttribute("admin", null);
		
		return "index";
	}
	
	
	
	/**
	 * signup
	 */
	@GetMapping("signup")
	public String showSignUpPage(Model model, HttpSession session, HttpServletRequest request) {
	    model.addAttribute("customer", new Customer());
		session.setAttribute("isChooseRoom", getPreviousPageByRequest(request).orElse("/").contains("chooseRoom")); 
 
	    return "signup";
	}
	
	@GetMapping("signup2")
	public String showSignUpPageFromPayment(Model model, HttpSession session, HttpServletRequest request) {
	    model.addAttribute("customer", new Customer());
 
	    return "signup";
	}
	
	@PostMapping("add")
	public String addCustomer(@Valid Customer customer, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "signup";
		}

		String email = customer.getEmail();
		int n = customerRepository.findByEmail(email);
		
		if(n > 0){
			model.addAttribute("signupFail", true);
			return "signup";
		}
		else {
			customerRepository.save(customer);
			return "login";
		}
	}
	
	
	
	
	
	
	//method
	private LocalDate stringToDate(String str) throws ParseException {
		str = str.replaceAll("[^0-9-]", "");
		
		return LocalDate.parse(str);
	}
	
	private void loadPaymentDetails(int id, HttpSession session) throws ParseException {
		//find room available
		int noOfRoom = (int) session.getAttribute("noOfRoom");
		String checkInDate = (String) session.getAttribute("checkInDate");
		String checkOutDate = (String) session.getAttribute("checkOutDate");
		
		List<Room> rooms = roomRepository.findAllByRoomTypeId((int) id, noOfRoom, stringToDate(checkInDate), stringToDate(checkOutDate));
		
		RoomType roomtype = roomTypeRepository.findById((int) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid roomtype Id: " + id));
		
		session.setAttribute("roomTypeId", id);
		session.setAttribute("roomType", roomtype);
		session.setAttribute("rooms", rooms);
		
		//booking, payment
		int noOfGuest = (int) session.getAttribute("noOfGuest");
		int duration = (int) session.getAttribute("duration");
		double roomPrice = ((RoomType) session.getAttribute("roomType")).getRoomPrice();
		
		Booking booking = new Booking(noOfGuest, noOfRoom, duration, checkInDate, checkOutDate);
		Payment payment = new Payment(roomPrice, noOfRoom, duration);
		
		session.setAttribute("booking", booking);
		session.setAttribute("payment", payment);		
	}
	
	protected Optional<String> getPreviousPageByRequest(HttpServletRequest request)
	{
	   return Optional.ofNullable(request.getHeader("Referer")).map(requestUrl -> "redirect:" + requestUrl);
	}
	
	

}
