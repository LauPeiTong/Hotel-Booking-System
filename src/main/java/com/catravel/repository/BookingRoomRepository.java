package com.catravel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.catravel.model.*;

@Repository
public interface BookingRoomRepository extends JpaRepository<BookingRoom, BookingRoomId>{
	//check unavailable room
//	@Query(value = "SELECT COUNT(room_id) FROM booking_room WHERE room_id IN (SELECT room_id FROM room WHERE room_type_id = :roomtypeid) AND ((:checkIn > check_in_date AND :checkIn < check_out_date) OR (:checkOut > check_in_date AND :checkOut < check_out_date))", 
//			  nativeQuery = true)
//	int countNoOfRoomNoAvailable(@Param("roomtypeid") int roomtypeid, @Param("checkIn") LocalDate checkInDate, @Param("checkOut") LocalDate checkOutDate);
	
	@Query(value = "SELECT COUNT(room_id) FROM booking_room NATURAL JOIN booking WHERE room_id IN (SELECT room_id FROM room WHERE room_type_id = :roomtypeid) AND "
			+ "((:checkIn > check_in_date AND :checkIn < check_out_date) OR (:checkOut > check_in_date AND :checkOut < check_out_date) OR (:checkIn <= check_in_date AND :checkOut >= check_out_date))", 
			  nativeQuery = true)
	public int countNoOfRoomNoAvailable(@Param("roomtypeid") int roomtypeid, @Param("checkIn") LocalDate checkInDate, @Param("checkOut") LocalDate checkOutDate);
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM booking_room WHERE booking_id = :bookingid", 
			  nativeQuery = true)
	public void deleteAllByBookingId(@Param("bookingid") int bookingid);
	
	@Query(value = "SELECT * FROM booking_room WHERE booking_id = :bookingid", 
			  nativeQuery = true)
	public List<BookingRoom> findAllByBookingId(@Param("bookingid") int bookingid);
	
	
}
