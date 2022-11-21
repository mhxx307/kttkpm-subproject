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

import com.sv.iuh.server.model.Car;
import com.sv.iuh.server.service.CarService;

@RestController
@RequestMapping("/api")
public class CarRestController {
	
	@Autowired
	private CarService carService;
	
	@GetMapping("/cars/{id}")
	public Car findById(@PathVariable int id) {
		return carService.findById(id);
	}
	
	@GetMapping("/cars")
	public List<Car> findAll() {
		return carService.findAll();
	}
	
	@DeleteMapping("/cars/{id}")
	public String deleteById(@PathVariable int id) {
		Car car = carService.findById(id);
		if (car == null) {
			return "Car id not found!";
		}
		carService.deleteById(id);
		return "Deleted successfully!";
	}
	
	@PostMapping("/cars")
	public Car addCar(@RequestBody Car car) {
		car.setId(0);
		carService.saveCar(car);
		return car;
	}
	
	@PutMapping("/cars")
	public Car updateCar(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}
	
}
