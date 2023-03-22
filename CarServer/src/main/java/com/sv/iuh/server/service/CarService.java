package com.sv.iuh.server.service;

import java.util.List;

import com.sv.iuh.server.model.Car;

public interface CarService {
	public List<Car> findAll();

	public Car findById(int carId);

	public void saveCar(Car car);

	public void deleteById(int id);
}
