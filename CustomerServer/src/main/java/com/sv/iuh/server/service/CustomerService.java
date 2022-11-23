package com.sv.iuh.server.service;

import java.util.List;

import com.sv.iuh.server.model.Customer;

public interface CustomerService {
	public List<Customer> findAll();

	public Customer findById(int customerId);

	public void saveCustomer(Customer customer);

	public void deleteById(int customerId);
}
