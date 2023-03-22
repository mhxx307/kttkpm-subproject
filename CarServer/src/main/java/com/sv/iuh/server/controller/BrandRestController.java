package com.sv.iuh.server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.server.model.Brand;
import com.sv.iuh.server.repository.BrandRedisRepository;
import com.sv.iuh.server.service.BrandService;


@RestController
@RequestMapping("/api")
public class BrandRestController {
	@Autowired
	private BrandService brandService;
	
	@Autowired
	private BrandRedisRepository brandRedisRepository;
	
	@GetMapping("/brands/{id}")
	public Brand findById(@PathVariable int id) {
		return brandService.findById(id);
	}
	
	@GetMapping("/brands")
	public List<Brand> findAll() {
		return brandService.findAll();
	}
	
	@DeleteMapping("/brands/{id}")
	public String deleteById(@PathVariable int id) {
		Brand brand = brandService.findById(id);
		if (brand == null) {
			return "Brand id not found!";
		}
		brandService.deleteById(id);
		return "Deleted successfully!";
	}
	
	@PostMapping("/brands")
	public Brand addBrand(@RequestBody Brand brand) {
		brand.setId(0);
		brandService.saveBrand(brand);
		
		brandRedisRepository.save(brand);
		return brand;
	}
	
	@PutMapping("/brands")
	public Brand updateCar(@RequestBody Brand brand) {
		brandService.saveBrand(brand);
		return brand;
	}
}
