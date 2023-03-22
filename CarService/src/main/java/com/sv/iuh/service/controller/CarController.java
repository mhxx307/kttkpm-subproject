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

import com.sv.iuh.service.entity.Car;
import com.sv.iuh.service.service.CarService;

@RestController
public class CarController {
	@Autowired
	private CarService carService;

	@PostMapping("/saveCar")
	public Car addCar(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}

	@GetMapping("/getCarById/{carId}")
	public Car getCarById(@PathVariable int carId) {
		return carService.findById(carId);
	}

	@GetMapping("/getCars")
	public List<Car> getBrands() {
		return carService.findAll();
	}

	@DeleteMapping("/deleteCarById/{carId}")
	public String deleteBrandById(@PathVariable int carId) {
		carService.deleteById(carId);
		return "Brand with id: " + carId + " was deleted";
	}

	@PutMapping("/updateCar")
	public Car updateCar(@RequestBody Car car) {
		carService.saveCar(car);
		return car;
	}
}
