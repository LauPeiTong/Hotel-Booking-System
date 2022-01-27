package com.catravel.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class RoomType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7210564640889819232L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "room_type_id")
	private Integer roomTypeId;
	
	@Column(name = "room_type")
	private String roomType;
	
	@Column(name = "room_price")
	private double roomPrice;
	
	@Column(name = "room_bed")
	private String roomBed;
	
	@Column(name = "is_available")
	private boolean isAvailable;
	
	@Column(name = "room_image_name")
	private String roomImageName;
	
	@Column(name = "no_of_room")
	private Integer noOfRoom;
	
	@Column(name = "room_service1")
	private String roomService1;
	
	@Column(name = "room_service2")
	private String roomService2;
	
	@OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
	private Set<Room> rooms;
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	private Hotel hotel;

	public RoomType() {
		super();
	}

	public Integer getRoomTypeId() {
		return roomTypeId;
	}

	public void setRoomTypeId(Integer roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getRoomPrice() {
		return roomPrice;
	}

	public void setRoomPrice(double roomPrice) {
		this.roomPrice = roomPrice;
	}

	public String getRoomBed() {
		return roomBed;
	}

	public void setRoomBed(String roomBed) {
		this.roomBed = roomBed;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getRoomImageName() {
		return roomImageName;
	}

	public void setRoomImageName(String roomImageName) {
		this.roomImageName = roomImageName;
	}

	public Integer getNoOfRoom() {
		return noOfRoom;
	}

	public void setNoOfRoom(Integer noOfRoom) {
		this.noOfRoom = noOfRoom;
	}
	
	public String getRoomService1() {
	    return roomService1;
	}

	public void setRoomService1(String roomService1) {
		this.roomService1 = roomService1;
	}
	
	public String getRoomService2() {
	    return roomService2;
	}

	public void setRoomService2(String roomService2) {
		this.roomService2 = roomService2;
	}
	
	
	
}
