package com.banu.cloud.locationapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banu.cloud.locationapi.model.Location;
import com.banu.cloud.locationapi.repository.LocationRepository;

@RestController
@RequestMapping("/api")
public class LocationController {
	
	@Autowired
	LocationRepository locationRepository;

	
	@GetMapping("/api/{city}")
	public ResponseEntity<Location> getCitybyName(@PathVariable(value= "city") String city){
	Location location= 	(Location) locationRepository.findbyCityName(city);
		return ResponseEntity.ok().body(location);
	} 
}
