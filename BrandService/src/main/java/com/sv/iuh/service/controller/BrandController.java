package com.sv.iuh.service.controller;

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

import com.sv.iuh.service.entity.Brand;
import com.sv.iuh.service.service.BrandService;

@RestController
@RequestMapping("/")
public class BrandController {
	@Autowired
	private BrandService brandService;

	@PostMapping("saveBrand")
	public Brand addBrand(@RequestBody Brand brand) {
		brandService.saveBrand(brand);
		return brand;
	}

	@GetMapping("getBrandById/{brandId}")
	public Brand getBrandById(@PathVariable int brandId) {
		return brandService.findById(brandId);
	}

	@GetMapping("getBrands")
	public List<Brand> getBrands() {
		return brandService.findAll();
	}

	@DeleteMapping("deleteBrandById/{brandId}")
	public String deleteBrandById(@PathVariable int brandId) {
		brandService.deleteById(brandId);
		return "Brand with id: " + brandId + " was deleted";
	}

	@PutMapping("updateBrand")
	public Brand updateBrand(@RequestBody Brand brand) {
		brandService.saveBrand(brand);
		return brand;
	}
}
