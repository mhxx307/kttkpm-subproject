package com.sv.iuh.server.service;

import java.util.List;

import com.sv.iuh.server.model.Bike;

public interface BikeService {

	public List<Bike> findAll();

	public Bike findById(int bikeId);

	public void saveBike(Bike bike);

	public void deleteById(int bikeId);

}
