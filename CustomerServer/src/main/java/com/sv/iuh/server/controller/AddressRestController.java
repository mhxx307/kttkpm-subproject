package com.sv.iuh.server.controller;

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

import com.sv.iuh.server.model.Address;
import com.sv.iuh.server.service.AddressService;

@RestController
@RequestMapping("/api")
public class AddressRestController {

	@Autowired
	private AddressService addressService;

	@GetMapping("/addresses")
	public List<Address> findAll() {
		return addressService.findAll();
	}

	@GetMapping("/addresses/{id}")
	public Address findById(@PathVariable int id) {
		return addressService.findById(id);
	}

	@DeleteMapping("/addresses/{id}")
	public String deleteById(@PathVariable int id) {
		Address address = addressService.findById(id);
		if (address == null)
			return "Address id not found!";
		addressService.deleteById(id);
		return "Deleted successfully!";
	}

	@PostMapping("/addresses")
	public Address addAddress(@RequestBody Address address) {
		address.setId(0);
		addressService.saveAddress(address);
		return address;
	}

	@PutMapping("/addresses")
	public Address updateAddress(@RequestBody Address address) {
		addressService.saveAddress(address);
		return address;
	}
}
