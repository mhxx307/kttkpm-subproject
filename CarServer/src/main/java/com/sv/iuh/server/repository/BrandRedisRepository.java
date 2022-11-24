package com.sv.iuh.server.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.sv.iuh.server.model.Brand;

@Repository
public class BrandRedisRepository {
	private static final String HASH_KEY = "Brand";

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate template;

	private HashOperations<String, Integer, Brand> hashOperations;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		hashOperations = template.opsForHash();
	}

	public Brand save(Brand brand) {
		hashOperations.put(HASH_KEY, brand.getId(), brand);
		return brand;
	}

	public List<Brand> findAll() {
		return hashOperations.values(HASH_KEY);
	}

	public Brand findBrandById(int id) {
		return hashOperations.get(HASH_KEY, id);
	}

	public String deleteBrand(int id) {
		hashOperations.delete(HASH_KEY, id);

		return "brand removed !!";
	}

}
