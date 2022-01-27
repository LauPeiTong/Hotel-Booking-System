package com.catravel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.catravel.model.Hotel;
@Repository

public interface HotelRepository extends JpaRepository<Hotel, Integer>{
	@Query(value = "SELECT * from hotel h WHERE UPPER(h.hotel_name || ' ' || h.street || ' ' || h.city || ' ' || h.state || ' ' || h.zip_code || ' ' || 'MALAYSIA') LIKE %?1%", nativeQuery = true)
	public List<Hotel> search(@Param("inputDestination") String inputDestination);
	
}
