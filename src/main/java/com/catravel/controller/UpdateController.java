package com.catravel.controller;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.catravel.model.*;
import com.catravel.repository.*;

/*
 * so far is only use one controller
 * ignore this
 */
@Controller
@RequestMapping("/update")
public class UpdateController {
	private final BookingRepository bookingRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private BookingRoomRepository bookingRoomRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	public UpdateController(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}
	
	@GetMapping("information")
	public String showInformation(Model model) {
		loadTable(model);
		
		return "update";
	}
	
	
	/**
	 * show update-booking
	 */
	@GetMapping("updateBooking/{bookingId}")
	public String showUpdateBooking(@PathVariable("bookingId") long id, Model model, HttpSession session){
		Booking booking = bookingRepository.findById((int) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid booking Id: " + id));
		
		List<Room> rooms =  roomRepository.findAllRoomByBookingId((int) id);
		Hotel hotel = rooms.get(0).getHotel();
		
		session.setAttribute("booking", booking);
		session.setAttribute("hotel", hotel);
		session.setAttribute("rooms", rooms);

		return "update-booking";
		
	}
	
	
	
	/**
	 * find room
	 */
	@RequestMapping(value = "updateBooking", params = "find", method = RequestMethod.POST)
	public String findRoomAvailable(@RequestParam("checkInDate") String checkInDate, @RequestParam("checkOutDate") String checkOutDate, @RequestParam("duration") int duration,
			@RequestParam("noOfGuest") int noOfGuest, @RequestParam("noOfRoom") int noOfRoom,
			HttpServletRequest request, HttpSession session) throws ParseException {
		
		Booking booking = (Booking)request.getSession().getAttribute("booking");
		int hotelid = ((Hotel)request.getSession().getAttribute("hotel")).getHotelId();
		
		LocalDate checkInDate1 = stringToDate(checkInDate);
		LocalDate checkOutDate1 = stringToDate(checkOutDate);
		int duration1 = duration;
		int noOfGuest1 = noOfGuest;
		int noOfRoom1 = noOfRoom;
		
		booking.setCheckInDate(checkInDate1);
		booking.setCheckOutDate(checkOutDate1);
		booking.setDuration(duration);
		booking.setNoOfGuest(noOfGuest);
		booking.setNoOfRoom(noOfRoom);
		session.setAttribute("booking", booking);
		
		List<Room> rooms = roomRepository.findAvailableRoom(hotelid, checkInDate1, checkOutDate1, booking.getBookingId());
		
		session.setAttribute("rooms", rooms);

		return "update-booking";
	}
	
	
	
	/**
	 * update booking
	 */
	@RequestMapping(value = "updateBooking", params = "update", method = RequestMethod.POST)
	public String updateBookingDetails(@RequestParam("room") List<String> room, Model model, HttpServletRequest request) {
		Booking booking = (Booking) request.getSession().getAttribute("booking");
		booking.setNoOfRoom(room.size());
		
		bookingRoomRepository.deleteAllByBookingId(booking.getBookingId());
				
		List<Room> rooms = new ArrayList();
		
		for(int i = 0; i < room.size(); i++) {
			Room r = (Room) roomRepository.findById(Integer.parseInt(room.get(i)))
					.orElseThrow(() -> new IllegalArgumentException("Invalid room Id"));
			
			rooms.add(r);
			BookingRoom bookingRoom = new BookingRoom(booking, r);
			bookingRoomRepository.save(bookingRoom);
			System.out.println();
		}
		bookingRepository.save(booking);
		
		Payment payment = paymentRepository.findByBookingId(booking.getBookingId());
		payment.calTotalAmount2(rooms, booking.getDuration());
		paymentRepository.save(payment);
		
		loadTable(model);
		
		return "update";
	}
	
	
	
	/**
	 * delete booking
	 */
	@RequestMapping(value = "updateBooking", params = "delete", method = RequestMethod.POST)
	public String deleteBooking(Model model, HttpServletRequest request) {
		Booking booking = (Booking) request.getSession().getAttribute("booking");
		
		bookingRoomRepository.deleteAllByBookingId(booking.getBookingId());
		bookingRepository.delete(booking);
		
		loadTable(model);
		
		return "update";
	}

	
	
	/**
	 * show update-booking
	 */
	@GetMapping("updateUser/{custId}")
	public String showUpdateUser(@PathVariable("custId") long id, Model model, HttpSession session){
		Customer customer = customerRepository.findById((int) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid customer Id: " + id));
		
		session.setAttribute("customerUpdate", customer);

		return "update-user";
		
	}
	
	
	
	/**
	 * update customer
	 */
	@RequestMapping(value = "updateUser", params = "update", method = RequestMethod.POST)
	public String updateUserDetails(Model model, HttpServletRequest request,  String phone,   String email) {
		Customer customer = (Customer) request.getSession().getAttribute("customerUpdate");
		customer.setEmail(email);
		customer.setPhone(phone);
		
		customerRepository.save(customer);
		
		loadTable(model);
		
		return "update";
	}
	
	
	
	/**
	 * delete customer
	 */
	@RequestMapping(value = "updateUser", params = "delete", method = RequestMethod.POST)
	public String deleteUser(Model model, HttpServletRequest request) {
		Customer customer = (Customer) request.getSession().getAttribute("customerUpdate");
		customerRepository.delete(customer);
		
		loadTable(model);
		
		return "update";
	}
	
	
	
	/**
	 * show update-hotel
	 */
	@GetMapping("updateHotel/{hotelId}")
	public String showUpdateHotel(@PathVariable("hotelId") long id, Model model, HttpSession session){
		Hotel hotel = hotelRepository.findById((int) id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid hotel Id: " + id));
		
		List<Room> rooms = roomRepository.findAllRoomByHotelId((int) id);
		
		session.setAttribute("hotelUpdate", hotel);
		model.addAttribute("rooms", rooms);

		return "update-hotel";
		
	}
	
	
	
	/**
	 * update hotel
	 */
	@RequestMapping(value = "updateHotel", params = "update", method = RequestMethod.POST)
	public String updateHotelDetails(Model model, HttpServletRequest request, String street, String city, String state, int zipCode, String hotelDes) {
		Hotel hotel = (Hotel) request.getSession().getAttribute("hotelUpdate");
		
		hotel.setStreet(street);
		hotel.setState(state);
		hotel.setCity(city);
		hotel.setZipCode(zipCode);
		hotel.setHotelDes(hotelDes);
		
		hotelRepository.save(hotel);
		
		loadTable(model);
		
		return "update";
	}
	
	
	
	
	//method
	private LocalDate stringToDate(String str) throws ParseException {
		str = str.replaceAll("[^0-9-]", "");
			
		return LocalDate.parse(str);
	}
	
	public void loadTable(Model model) {
		List<Booking> bookings = bookingRepository.findAll();
		List<Customer> customers = customerRepository.findAll();
		List<Hotel> hotels = hotelRepository.findAll();

		model.addAttribute("bookings", bookings);
		model.addAttribute("customers", customers);
		model.addAttribute("hotels", hotels);
	}
	
	
}
