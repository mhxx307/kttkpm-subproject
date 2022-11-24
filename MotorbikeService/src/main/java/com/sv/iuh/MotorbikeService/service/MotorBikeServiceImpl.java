package com.sv.iuh.MotorbikeService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.MotorbikeService.entity.MotorBike;


@Service
public class MotorBikeServiceImpl implements MotorBikeService{
	
	private RestTemplate restTemplate;
	private String crmUrl;
	
	
	@Autowired
	public MotorBikeServiceImpl(RestTemplate restTemplate,@Value("${crm.url.motorbikes}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}

	@Override
	public List<MotorBike> findAll() {
		ResponseEntity<List<MotorBike>> responseEntity=restTemplate.exchange(crmUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<MotorBike>>() {
				});
		List<MotorBike> motorbikes = responseEntity.getBody();
		return motorbikes;
	}

	@Override
	public MotorBike findById(int id) {
		return restTemplate.getForObject(crmUrl + "/" + id, MotorBike.class);
	}

	@Override
	public void saveMotorBike(MotorBike motorbike) {
		int id = motorbike.getId();
		if(id == 0) {
			restTemplate.postForEntity(crmUrl, motorbike, String.class);
			
		}else {
			restTemplate.put(crmUrl, motorbike);
		}

	}

	@Override
	public void deleteById(int id) {
		restTemplate.delete(crmUrl +"/" + id);
		
	}
	
}
