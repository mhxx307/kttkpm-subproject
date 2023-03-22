package com.sv.iuh.service.service;

import java.util.List;

import com.sv.iuh.service.entity.Car;

public interface CarService {
	public List<Car> findAll();

	public Car findById(int carId);

	public void saveCar(Car car);

	public void deleteById(int id);
}
