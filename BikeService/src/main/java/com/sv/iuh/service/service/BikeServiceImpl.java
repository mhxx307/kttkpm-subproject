package com.sv.iuh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.service.entity.Bike;


@Service
public class BikeServiceImpl implements BikeService {

	private RestTemplate restTemplate;
	private String crmUrl;

	@Autowired
	public BikeServiceImpl(RestTemplate restTemplate, @Value("${crm.url.bikes}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}

	@Override
	public List<Bike> findAll() {
		ResponseEntity<List<Bike>> responseEntity=restTemplate.exchange(crmUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Bike>>() {
				});
		List<Bike> bikes = responseEntity.getBody();
		return bikes;
	}

	@Override
	public Bike findById(int bikeId) {
		return restTemplate.getForObject(crmUrl + "/" + bikeId, Bike.class);
	}

	@Override
	public void saveBike(Bike bike) {
	
		int bikeId = bike.getId();
		if(bikeId == 0) {
			restTemplate.postForEntity(crmUrl, bikeId, String.class);
			
		}else {
			restTemplate.put(crmUrl, bikeId);
		}

	}

	@Override
	public void deleteById(int bikeId) {
		restTemplate.delete(crmUrl +"/" + bikeId);

	}

}
