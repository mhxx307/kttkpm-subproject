package com.sv.iuh.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.server.model.Address;
import com.sv.iuh.server.repository.AddressRepository;
import com.sv.iuh.server.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	@Transactional
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	@Transactional
	public Address findById(int addressId) {
		return addressRepository.findById(addressId).get();
	}

	@Override
	@Transactional
	public void saveAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	@Transactional
	public void deleteById(int addressId) {
		addressRepository.deleteById(addressId);
	}

}
