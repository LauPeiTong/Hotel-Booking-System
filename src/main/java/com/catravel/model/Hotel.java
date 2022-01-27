package com.catravel.model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


@Entity
public class Hotel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 672096434921326923L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private Integer hotelId;
	
	@Column(name = "hotel_name")
	private String hotelName;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "zip_code")
	private Integer zipCode;
	
	@Column(name = "hotel_des")
	private String hotelDes;
	
	@Column(name = "min_price")
	private double minPrice;

	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Set<Room> rooms;
	
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private Set<RoomType> roomTypes;
	
	@Column(name = "hotel_image_name")
	private String hotelImageName;
	
	//hotelDes2
	//hotelDes3
	//rating - 有时间才做
	
	public Hotel() {
		super();
	}
	
	public Integer getHotelId() {
		return hotelId;
	}

	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getHotelDes() {
		return hotelDes;
	}

	public void setHotelDes(String hotelDes) {
		this.hotelDes = hotelDes;
	}

	public Set<Room> getRooms() {
		return rooms;
	}

	public void setRooms(Set<Room> rooms) {
		this.rooms = rooms;
	}

	public Set<RoomType> getRoomTypes() {
		return roomTypes;
	}

	public void setRoomTypes(Set<RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public String getHotelImageName() {
		return hotelImageName;
	}

	public void setHotelImageName(String hotelImageName) {
		this.hotelImageName = hotelImageName;
	}

	
	
	

}
