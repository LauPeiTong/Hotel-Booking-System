package com.catravel.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class BookingRoom {
	@EmbeddedId
	private BookingRoomId id;
	
	@ManyToOne
	@MapsId("bookingId")
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@ManyToOne
	@MapsId("roomId")
	@JoinColumn(name = "room_id")
	private Room room;
	
//	@Column(name = "check_in_date")
//	private LocalDate checkInDate;
//	
//	@Column(name = "check_out_date")
//	private LocalDate checkOutDate;
	
	//private boolean isConfirm 不确定要不要加

	public BookingRoom() {
		super();
	}

	public BookingRoom(Booking booking, Room room) {
		super();
		this.id = new BookingRoomId(booking.getBookingId(), room.getRoomId());
		this.booking = booking;
		this.room = room;
//		this.checkInDate = stringToDate(checkInDate);
//		this.checkOutDate = stringToDate(checkOutDate);
	}

	private LocalDate stringToDate(String str) {
		str = str.replaceAll("[^0-9-]", "");
		
		return LocalDate.parse(str);
	}

	public BookingRoomId getId() {
		return id;
	}

	public void setId(BookingRoomId id) {
		this.id = id;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
//	public LocalDate getCheckInDate() {
//		return checkInDate;
//	}
//
//	public void setCheckInDate(LocalDate checkInDate) {
//		this.checkInDate = checkInDate;
//	}
//
//	public LocalDate getCheckOutDate() {
//		return checkOutDate;
//	}
//
//	public void setCheckOutDate(LocalDate checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}


	
	
}

