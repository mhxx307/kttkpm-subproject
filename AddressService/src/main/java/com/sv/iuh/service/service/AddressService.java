package com.sv.iuh.service.service;

import java.util.List;

import com.sv.iuh.service.entity.Address;

public interface AddressService {
	public List<Address> findAll();

	public Address findById(int addressId);

	public void saveAddress(Address address);

	public void deleteById(int addressId);
}
