package com.catravel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.*;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer>{
	@Query(value = "SELECT * FROM payment WHERE booking_id = :bookingid", 
			  nativeQuery = true)
	public Payment findByBookingId(@Param("bookingid") int bookingid);
}
