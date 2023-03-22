package com.sv.iuh.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.server.model.Bike;
import com.sv.iuh.server.repository.BikeRepository;
import com.sv.iuh.server.service.BikeService;

@Service
public class BikeServiceImpl implements BikeService {

	@Autowired
	private BikeRepository bikeRepository;
	
	@Override
	@Transactional
	public List<Bike> findAll() {
		return bikeRepository.findAll();
	}

	@Override
	@Transactional
	public Bike findById(int bikeId) {
		return bikeRepository.findById(bikeId).get();
	}

	@Override
	@Transactional
	public void saveBike(Bike bike) {
		bikeRepository.save(bike);
		
	}

	@Override
	@Transactional
	public void deleteById(int bikeId) {
		bikeRepository.deleteById(bikeId);
		
	}

}
