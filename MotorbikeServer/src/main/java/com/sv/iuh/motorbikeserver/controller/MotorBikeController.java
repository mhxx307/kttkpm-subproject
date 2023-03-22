package com.sv.iuh.motorbikeserver.controller;

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

import com.sv.iuh.motorbikeserver.model.MotorBike;
import com.sv.iuh.motorbikeserver.service.MotorBikeService;



@RestController
@RequestMapping("/api")
public class MotorBikeController {
	@Autowired
	private MotorBikeService motorbikeService;
	@GetMapping("/motorbikes/{id}")
	public MotorBike findByID(@PathVariable int id) {
		return motorbikeService.findById(id);
	}
	
	@GetMapping("/motorbikes")
	public List<MotorBike> findAll(){
		return motorbikeService.findAll();
	}
	
	@PostMapping("/motorbikes")
	public MotorBike addMotorBike(@RequestBody MotorBike motorBike) {
		motorBike.setId(0);
		motorbikeService.saveMotorBike(motorBike);
		return motorBike;
	}
	
	@PutMapping("/motorbikes")
	public MotorBike updateMotorBike(@RequestBody MotorBike motorBike) {
		motorbikeService.saveMotorBike(motorBike);
		return motorBike;
	}
	
	@DeleteMapping("/motorbikes/{id}")
	public String deleteById(@PathVariable int id) {
		MotorBike motBike = motorbikeService.findById(id);
		if(motBike == null) {
			return "motorbile Id not found";
		}
		motorbikeService.deleteById(id);
		return "Deleted";
	}
}
