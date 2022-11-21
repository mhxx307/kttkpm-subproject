package com.sv.iuh.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.server.model.Brand;
import com.sv.iuh.server.repository.BrandRepository;
import com.sv.iuh.server.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService  {
	
	@Autowired
	private BrandRepository brandRepository;

	@Override
	@Transactional
	public List<Brand> findAll() {
		return brandRepository.findAll();
	}

	@Override
	@Transactional
	public Brand findById(int brandId) {
		return brandRepository.findById(brandId).get();
	}

	@Override
	@Transactional
	public void saveBrand(Brand brand) {
		brandRepository.save(brand);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		brandRepository.deleteById(id);
	}
	
}
