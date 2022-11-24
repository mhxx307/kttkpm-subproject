package com.sv.iuh.server.repository;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.sv.iuh.server.model.Car;

@Repository
public class CarRedisReposiroty {
	private static final String HASH_KEY = "Car";

	@SuppressWarnings("rawtypes")
	@Autowired
	private RedisTemplate template;

	private HashOperations<String, Integer, Car> hashOperations;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		hashOperations = template.opsForHash();
	}

	public Car save(Car car) {
		hashOperations.put(HASH_KEY, car.getId(), car);
		return car;
	}

	public List<Car> findAll() {
		return hashOperations.values(HASH_KEY);
	}

	public Car findCarById(int id) {
		return hashOperations.get(HASH_KEY, id);
	}

	public String deleteCarById(int id) {
		hashOperations.delete(HASH_KEY, id);

		return "brand removed !!";
	}

}
