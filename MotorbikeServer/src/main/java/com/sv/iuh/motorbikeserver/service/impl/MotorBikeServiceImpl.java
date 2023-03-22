package com.sv.iuh.motorbikeserver.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.motorbikeserver.model.MotorBike;
import com.sv.iuh.motorbikeserver.repository.MotorBikeRepository;
import com.sv.iuh.motorbikeserver.service.MotorBikeService;

@Service
public class MotorBikeServiceImpl implements MotorBikeService{
	
	@Autowired
	private MotorBikeRepository motorbikeRepository;

	@Override
	@Transactional
	public List<MotorBike> findAll() {
		return motorbikeRepository.findAll();
	}

	@Override
	@Transactional
	public MotorBike findById(int id) {
		return motorbikeRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void saveMotorBike(MotorBike motorbike) {
		motorbikeRepository.save(motorbike);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		motorbikeRepository.deleteById(id);
		
	}
	
}
