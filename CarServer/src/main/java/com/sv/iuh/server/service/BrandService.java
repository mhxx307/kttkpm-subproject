package com.sv.iuh.server.service;

import java.util.List;

import com.sv.iuh.server.model.Brand;

public interface BrandService {
	public List<Brand> findAll();

	public Brand findById(int brandId);

	public void saveBrand(Brand brand);

	public void deleteById(int id);
}
