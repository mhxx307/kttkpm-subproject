package com.sv.iuh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.service.entity.Car;

@Service
public class CarServiceImpl implements CarService {
	private RestTemplate restTemplate;
	private String crmUrl;

	@Autowired
	public CarServiceImpl(RestTemplate theRestTemplate, @Value("${crm.url.cars}") String theCrmUrl) {
		restTemplate = theRestTemplate;
		crmUrl = theCrmUrl;
	}

	@Override
	public List<Car> findAll() {
		ResponseEntity<List<Car>> responseEntity = restTemplate.exchange(crmUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Car>>() {
				});
		List<Car> cars = responseEntity.getBody();
		return cars;
	}

	@Override
	public void deleteById(int id) {
		restTemplate.delete(crmUrl + "/" + id);
	}

	@Override
	public Car findById(int carId) {
		Car car = restTemplate.getForObject(crmUrl + "/" + carId, Car.class);
		return car;
	}

	@Override
	public void saveCar(Car car) {
		int carId = car.getId();
		if (carId == 0) {
			restTemplate.postForEntity(crmUrl, carId, String.class);
		} else {
			restTemplate.put(crmUrl, carId);
		}

	}
}
