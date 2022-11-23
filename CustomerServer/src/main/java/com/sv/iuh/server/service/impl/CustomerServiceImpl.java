package com.sv.iuh.server.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sv.iuh.server.model.Customer;
import com.sv.iuh.server.repository.CustomerRepository;
import com.sv.iuh.server.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	@Transactional
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	@Transactional
	public Customer findById(int customerId) {
		return customerRepository.findById(customerId).get();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	@Override
	@Transactional
	public void deleteById(int customerId) {
		customerRepository.deleteById(customerId);
	}

}
