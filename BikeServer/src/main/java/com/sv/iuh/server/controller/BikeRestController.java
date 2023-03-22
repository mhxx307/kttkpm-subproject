package com.sv.iuh.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.server.model.Bike;
import com.sv.iuh.server.service.BikeService;

@RestController
@RequestMapping("/api")
public class BikeRestController {
	@Autowired
	private BikeService bikeService;
	
	@GetMapping("/bikes/{id}")
	public Bike findByID(@PathVariable int id) {
		return bikeService.findById(id);
	}
	
	@GetMapping("/bikes")
	public List<Bike> findAll(){
		return bikeService.findAll();
	}
	@PostMapping("/bikes")
	public Bike addBike(@RequestBody Bike bike) {
		bike.setId(0);
		bikeService.saveBike(bike);
		return bike;
	}
	@PutMapping("/bikes")
	public Bike updateBike(@RequestBody Bike bike) {
		bikeService.saveBike(bike);
		return bike;
	}
	@DeleteMapping("/bikes/{id}")
	public String deleteById(@PathVariable int id) {
		Bike bike =bikeService.findById(id);
		if(bike == null) {
			return "bike Id not found!";
		}
		bikeService.deleteById(id);
		return "Deleted";
	}

}
