package com.sv.iuh.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.server.model.Car;
import com.sv.iuh.server.repository.CarRepository;
import com.sv.iuh.server.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	@Transactional
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	@Transactional
	public Car findById(int carId) {
		return carRepository.findById(carId).get();
	}

	@Override
	@Transactional
	public void saveCar(Car car) {
		carRepository.save(car);

	}

	@Override
	@Transactional
	public void deleteById(int id) {
		carRepository.deleteById(id);
	}

}
