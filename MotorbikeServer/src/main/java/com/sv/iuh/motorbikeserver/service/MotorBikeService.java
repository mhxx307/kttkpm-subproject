package com.sv.iuh.motorbikeserver.service;

import java.util.List;

import com.sv.iuh.motorbikeserver.model.MotorBike;


public interface MotorBikeService {
	public List<MotorBike> findAll();

	public MotorBike findById(int id);

	public void saveMotorBike(MotorBike motorbike);

	public void deleteById(int id);

}
