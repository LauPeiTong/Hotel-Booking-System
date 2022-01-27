package com.catravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.*;

@Repository
public interface RoomTypeRepository extends JpaRepository<RoomType, Integer>{
	@Query(value = "SELECT * FROM room_type WHERE hotel_id = :id", nativeQuery = true)
	List<RoomType> findAllByHotelId(@Param("id") int id);
	
}
