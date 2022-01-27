package com.catravel.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class BookingRoomId implements Serializable{
	@Column(name = "booking_id")
	private Integer bookingId;
	
	@Column(name = "room_id")
	private Integer roomId;


	public BookingRoomId() {
		super();
	}


	public BookingRoomId(Integer bookingId, Integer roomId) {
		super();
		this.bookingId = bookingId;
		this.roomId = roomId;
	}


	@Override
	public int hashCode() {
		return Objects.hash(bookingId, roomId);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingRoomId other = (BookingRoomId) obj;
		return Objects.equals(bookingId, other.bookingId) && Objects.equals(roomId, other.roomId);
	}
	
	
	
}
