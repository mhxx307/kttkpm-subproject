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

import com.sv.iuh.service.entity.Customer;
import com.sv.iuh.service.service.CustomerService;

@RestController
@RequestMapping("/")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("getCustomers")
	public List<Customer> getCustomers() {
		return customerService.findAll();
	}

	@GetMapping("getCustomerById/{customerId}")
	public Customer getCustomerById(@PathVariable int customerId) {
		return customerService.findById(customerId);
	}

	@PostMapping("saveCustomer")
	public Customer addCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@PutMapping("updateCustomer")
	public Customer updateCustomer(@RequestBody Customer customer) {
		customerService.saveCustomer(customer);
		return customer;
	}

	@DeleteMapping("deleteCustomerById/{customerId}")
	public String deleteCustomerById(@PathVariable int customerId) {
		customerService.deleteById(customerId);
		return "Customer with id: " + customerId + "was deleted";
	}
}
