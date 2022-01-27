package com.catravel.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.*;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
	@Query(value = "SELECT * FROM room WHERE room_type_id = :roomtypeid "
			+ " AND room_id NOT IN (SELECT room_id FROM booking_room NATURAL JOIN booking WHERE "
			+ "((:checkIn > check_in_date AND :checkIn < check_out_date) OR (:checkOut > check_in_date AND :checkOut < check_out_date) OR (:checkIn <= check_in_date AND :checkOut >= check_out_date)))"
			+ " AND ROWNUM <= :noOfRoom", nativeQuery = true)
	List<Room> findAllByRoomTypeId(@Param("roomtypeid") int roomtypeid, @Param("noOfRoom") int noOfRoom, @Param("checkIn") LocalDate checkInDate, @Param("checkOut") LocalDate checkOutDate);
	
	@Query(value = "SELECT * FROM room WHERE room_id IN (SELECT room_id FROM booking_room WHERE booking_id = :bookingId)", 
			  nativeQuery = true)
	public List<Room> findAllRoomByBookingId(@Param("bookingId") int bookingId);
	
	@Query(value = "SELECT * FROM room r WHERE r.hotel_id = :hotelid AND "
			+ "r.room_id NOT IN (SELECT room_id FROM booking_room NATURAL JOIN booking WHERE "
			+ "((:checkIn > check_in_date AND :checkIn < check_out_date) OR (:checkOut > check_in_date AND :checkOut < check_out_date) OR (:checkIn <= check_in_date AND :checkOut >= check_out_date))"
			+ "AND booking_id != :bookingid)"
			+ "ORDER BY room_id", nativeQuery = true)
	public List<Room> findAvailableRoom(@Param("hotelid") int hotelid, @Param("checkIn") LocalDate checkInDate, @Param("checkOut") LocalDate checkOutDate, @Param("bookingid") int bookingId);

	@Query(value = "SELECT * FROM room WHERE hotel_id = :hotelId", 
			  nativeQuery = true)
	public List<Room> findAllRoomByHotelId(@Param("hotelId") int hotelId);

}
