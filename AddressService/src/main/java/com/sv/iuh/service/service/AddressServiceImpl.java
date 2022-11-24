package com.sv.iuh.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sv.iuh.service.entity.Address;

@Service
public class AddressServiceImpl implements AddressService{
	private RestTemplate restTemplate;
	private String crmUrl;
	
	
	@Autowired
	public AddressServiceImpl(RestTemplate restTemplate, @Value("${crm.url.addresses}") String crmUrl) {
		super();
		this.restTemplate = restTemplate;
		this.crmUrl = crmUrl;
	}

	@Override
	public List<Address> findAll() {
		ResponseEntity<List<Address>> responseEntity = restTemplate.exchange(crmUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Address>>() {
				});
		List<Address> addresses = responseEntity.getBody();
		return addresses;
	}

	@Override
	public Address findById(int addressId) {
		Address address = restTemplate.getForObject(crmUrl + "/" + addressId, Address.class);
		return address;
	}

	@Override
	public void saveAddress(Address address) {
		int addressId = address.getId();
		if(addressId == 0) {
			restTemplate.postForEntity(crmUrl, address, String.class);
		} else {
			restTemplate.put(crmUrl + "/", address);
		}
	}

	@Override
	public void deleteById(int addressId) {
		restTemplate.delete(crmUrl + "/" + addressId);
	}

}
