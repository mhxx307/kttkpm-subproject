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

import com.sv.iuh.server.model.Customer;
import com.sv.iuh.server.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/customers/{id}")
	public Customer findById(@PathVariable int id) {
		return customerService.findById(id);
	}
	
	@DeleteMapping("/customers/{id}")
	public String deleteById(@PathVariable int id) {
		Customer customer = customerService.findById(id);
		if(customer == null)
			return "Customer is not found!";
		customerService.deleteById(id);
		return "Deleted successfully!";
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}
}
