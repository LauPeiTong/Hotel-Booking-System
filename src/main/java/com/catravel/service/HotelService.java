package com.catravel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.catravel.repository.HotelRepository;
import com.catravel.model.*;

@Service
public class HotelService {
	@Autowired
	private HotelRepository hotelRepository;
	
	//useless
	public List<Hotel> listAll(String inputDestination){
		if(inputDestination != null) {
			return hotelRepository.search(inputDestination);
		}
		return hotelRepository.findAll();
	}
}
