package com.sv.iuh.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.service.entity.Bike;
import com.sv.iuh.service.service.BikeService;

@RestController
public class BikeController {
	@Autowired
	private BikeService bikeService;

	@PostMapping("/saveBike")
	public Bike addBike(@RequestBody Bike bike) {
		bikeService.saveBike(bike);
		return bike;
	}
	@GetMapping("/getBikeById/{id}")
	public Bike getBikeById(@PathVariable int id) {
		return bikeService.findById(id);
	}
	@GetMapping("/getBikes")
	public List<Bike> getBikes(){
		return bikeService.findAll();
	}
	@PutMapping("/updateBike")
	public Bike updateBike(@RequestBody Bike bike) {
		bikeService.saveBike(bike);
		return bike;
	}
	@DeleteMapping("/deleteBikeId/{id}")
	public String deleteBikeId(@PathVariable int id) {
		bikeService.deleteById(id);
		return "Deleted";
	}
}
