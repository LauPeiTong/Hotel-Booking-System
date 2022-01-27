package com.catravel.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Payment implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2414267977580030665L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	private Integer paymentId;
	
	@Column(name = "total_amount")
	private double totalAmount;
	
	@Column(name = "payment_confirm_date")
	private LocalDate paymentConfirmDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	//isPay 不确定要不要加
	
	//有时间才做
//	private String cardOwner;
//	private String cardNumber;
//	private Integer cvv;
//	private Integer validMonth;
//	private Integer validYear;
	
	public Payment() {
		super();
	}
	
	public Payment(double roomPrice, int noOfRoom, int duration) {
		super();
		calTotalAmount(roomPrice, noOfRoom, duration);
		this.paymentConfirmDate = LocalDate.now();
		this.booking = booking;
	}

	public Integer getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
	
	public void calTotalAmount(double roomPrice, int noOfRoom, int duration) {
		this.totalAmount = roomPrice * noOfRoom * duration;
	}
	
	public void calTotalAmount2(List<Room> rooms, int duration) {
		this.totalAmount = 0;
		for(int i = 0; i < rooms.size(); i++) { 
			this.totalAmount += rooms.get(i).getRoomType().getRoomPrice();
		}
		
		this.totalAmount = totalAmount * duration;
	}
	
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public LocalDate getPaymentConfirmDate() {
		return paymentConfirmDate;
	}

	public void setPaymentConfirmDate(LocalDate paymentConfirmDate) {
		this.paymentConfirmDate = paymentConfirmDate;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	

//	public String getCardOwner() {
//		return cardOwner;
//	}
//
//	public void setCardOwner(String cardOwner) {
//		this.cardOwner = cardOwner;
//	}
//
//	public String getCardNumber() {
//		return cardNumber;
//	}
//
//	public void setCardNumber(String cardNumber) {
//		this.cardNumber = cardNumber;
//	}
//
//	public Integer getCvv() {
//		return cvv;
//	}
//
//	public void setCvv(Integer cvv) {
//		this.cvv = cvv;
//	}
//
//	public Integer getValidMonth() {
//		return validMonth;
//	}
//
//	public void setValidMonth(Integer validMonth) {
//		this.validMonth = validMonth;
//	}
//
//	public Integer getValidYear() {
//		return validYear;
//	}
//
//	public void setValidYear(Integer validYear) {
//		this.validYear = validYear;
//	}

	
	
	

}
