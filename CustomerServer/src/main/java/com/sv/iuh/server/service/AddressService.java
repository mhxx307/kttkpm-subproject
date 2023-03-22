package com.sv.iuh.server.service;

import java.util.List;

import com.sv.iuh.server.model.Address;

public interface AddressService {
	public List<Address> findAll();
	
	public Address findById(int addressId);
	
	public void saveAddress(Address address);
	
	public void deleteById(int addressId);
}
