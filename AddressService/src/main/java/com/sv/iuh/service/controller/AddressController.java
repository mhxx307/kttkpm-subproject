package com.sv.iuh.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sv.iuh.service.entity.Address;
import com.sv.iuh.service.service.AddressService;

@RestController
@RequestMapping("/")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@GetMapping("getAddresses")
	public List<Address> getAddresses() {
		return addressService.findAll();
	}
	
	@GetMapping("getAddressById/{addressId}")
	public Address getAddressById(@PathVariable int addressId) {
		return addressService.findById(addressId);
	}
	
	@PostMapping("saveAddress")
	public Address addAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return address;
	}
	
	@PutMapping("updateAddress")
	public Address updateAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return address;
	}
	
	@DeleteMapping("deleteAddressById/{addressId}")
	public String deleteAddressById(@PathVariable int addressId) {
		addressService.deleteById(addressId);
		return "Address with id: " + addressId + "was deleted";
	}
}
