package com.sv.iuh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.service.entity.Brand;

@Service
public class BrandServiceImpl implements BrandService {
	private RestTemplate restTemplate;
	private String crmUrl;

	@Autowired
	public BrandServiceImpl(RestTemplate theRestTemplate, @Value("${crm.url.brands}") String theCrmUrl) {
		restTemplate = theRestTemplate;
		crmUrl = theCrmUrl;
	}

	@Override
	public List<Brand> findAll() {
		ResponseEntity<List<Brand>> responseEntity = restTemplate.exchange(crmUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Brand>>() {
				});
		List<Brand> brands = responseEntity.getBody();
		return brands;
	}

	@Override
	public Brand findById(int brandId) {
		Brand brand = restTemplate.getForObject(crmUrl + "/" + brandId, Brand.class);
		return brand;
	}

	@Override
	public void saveBrand(Brand brand) {
		int brandId = brand.getId();
		if (brandId == 0) {
			restTemplate.postForEntity(crmUrl, brand, String.class);
		} else {
			restTemplate.put(crmUrl, brand);
		}
	}

	@Override
	public void deleteById(int id) {
		restTemplate.delete(crmUrl + "/" + id);

	}
}
