package com.sv.iuh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.service.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	private RestTemplate restTemplate;
	private String crmUrl;

	@Autowired
	public CustomerServiceImpl(RestTemplate restTemplate, @Value("${crm.url.customers}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}

	@Override
	public List<Customer> findAll() {
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(crmUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Customer>>() {
				});
		List<Customer> customers = responseEntity.getBody();
		return customers;
	}

	@Override
	public Customer findById(int customerId) {
		Customer customer = restTemplate.getForObject(crmUrl + "/" + customerId, Customer.class);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
		int customerId = customer.getId();
		if (customerId == 0) {
			restTemplate.postForEntity(crmUrl, customerId, String.class);
		} else {
			restTemplate.put(crmUrl + "/", customerId);
		}
	}

	@Override
	public void deleteById(int customerId) {
		restTemplate.delete(crmUrl + "/" + customerId);
	}

}
