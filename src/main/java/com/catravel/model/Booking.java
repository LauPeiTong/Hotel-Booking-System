package com.catravel.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Booking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5477034061036797066L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "booking_id")
	private Integer bookingId;
	
	@ManyToOne
	@JoinColumn(name = "cust_id")
	private Customer customer;
	
	@OneToOne(mappedBy = "booking", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Payment payment;
	
	@OneToMany(mappedBy = "booking", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<BookingRoom> bookingRooms = new HashSet<>();
	
	@Column(name = "no_of_guest")
	private Integer noOfGuest;
	
	@Column(name = "no_of_room")
	private Integer noOfRoom;
	
	@Column(name = "duration")
	private Integer duration;
	
	@Column(name = "check_in_date")
	private LocalDate checkInDate;
	
	@Column(name = "check_out_date")
	private LocalDate checkOutDate;
	
//	@Column(name = "is_book")
//	private boolean isBook;
	
	
	public Booking() {
		super();
	}
	
	public Booking(Integer noOfGuest, Integer noOfRoom, Integer duration, String checkInDate, String checkOutDate) {
		super();
		this.noOfGuest = noOfGuest;
		this.noOfRoom = noOfRoom;
		this.duration = duration;
//		this.isBook = false;
		this.checkInDate = stringToDate(checkInDate);
		this.checkOutDate = stringToDate(checkOutDate);
	}


	public Integer getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public Set<BookingRoom> getBookingRooms() {
		return bookingRooms;
	}

	public void setBookingRooms(Set<BookingRoom> bookingRooms) {
		this.bookingRooms = bookingRooms;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Integer getNoOfGuest() {
		return noOfGuest;
	}

	public void setNoOfGuest(Integer noOfGuest) {
		this.noOfGuest = noOfGuest;
	}

	public Integer getNoOfRoom() {
		return noOfRoom;
	}

	public void setNoOfRoom(Integer noOfRoom) {
		this.noOfRoom = noOfRoom;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

//	public boolean isBook() {
//		return isBook;
//	}
//
//	public void setBook(boolean isBook) {
//		this.isBook = isBook;
//	}
	
	private LocalDate stringToDate(String str) {
		str = str.replaceAll("[^0-9-]", "");
		
		return LocalDate.parse(str);
	}

	
  
}
