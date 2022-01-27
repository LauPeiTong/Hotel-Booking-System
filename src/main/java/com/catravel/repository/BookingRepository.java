package com.catravel.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.catravel.model.*;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
