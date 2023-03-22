package com.sv.iuh.service.service;

import java.util.List;

import com.sv.iuh.service.entity.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int customerId);

	public void saveCustomer(Customer customer);

	public void deleteById(int customerId);
}
