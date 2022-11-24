package com.sv.iuh.MotorbikeService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.MotorbikeService.entity.MotorBike;
import com.sv.iuh.MotorbikeService.service.MotorBikeService;


@RestController
public class MotorBikeController {
	@Autowired
	private MotorBikeService motorBikeService;
	
	@PostMapping("/saveMotorBike")
	public MotorBike addMotorBike(@RequestBody MotorBike motorbike) {
		motorBikeService.saveMotorBike(motorbike);
		return motorbike;
	}
	@GetMapping("/getMotorBikeById/{id}")
	public MotorBike getMotorBikeById(@PathVariable int id) {
		return motorBikeService.findById(id);
	}
	@GetMapping("/getMotorBikes")
	public List<MotorBike> getMotorBikes(){
		return motorBikeService.findAll();
	}
	@PutMapping("/updateMotorBike")
	public MotorBike updateMotorBike(@RequestBody MotorBike motorbike) {
		motorBikeService.saveMotorBike(motorbike);
		return motorbike;
	}
	@DeleteMapping("/deleteMotorBikeId/{id}")
	public String deleteMotorBikeId(@PathVariable int id) {
		motorBikeService.deleteById(id);
		return "Deleted";
	}
}
