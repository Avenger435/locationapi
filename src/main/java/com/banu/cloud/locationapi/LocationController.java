package com.banu.cloud.locationapi;

import java.util.List;

import javax.enterprise.inject.spi.Bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banu.cloud.locationapi.model.Location;
import com.banu.cloud.locationapi.repository.LocationRepository;

@RestController
@RequestMapping("/api")
@EnableAutoConfiguration
@ComponentScan
public class LocationController {
	
	public LocationController(LocationRepository locationRepository) {
		super();
		this.locationRepository = locationRepository;
	}


	@Autowired
	LocationRepository locationRepository;

	@GetMapping("/{city}")
	public ResponseEntity<List<Location>> findall(@PathVariable(value= "city") String city){
	List<Location> location= locationRepository.findAll();
	
	System.out.println("Location"+location);
		return ResponseEntity.ok().body(location); 
	} 
	
	@GetMapping("/api/{city}")
	public ResponseEntity<Location> findbyCityName(@PathVariable(value= "city") String city){
	Location location= 	(Location) locationRepository.getOne(city);
	System.out.println("Location"+location);
		return ResponseEntity.ok().body(location);
	} 
}
