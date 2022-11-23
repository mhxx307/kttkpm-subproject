package com.sv.iuh.service.service;

import java.util.List;

import com.sv.iuh.service.entity.Bike;

public interface BikeService {
	public List<Bike> findAll();

	public Bike findById(int bikeId);

	public void saveBike(Bike bike);

	public void deleteById(int bikeId);

}
