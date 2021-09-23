package com.springboot.bankingApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingApp.entity.Customer;
import com.springboot.bankingApp.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
		
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerByCusId(long id) {
		// TODO Auto-generated method stub
		return customerRepository.getById(id);
	}

	@Override
	public void saveOrUpdateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		customerRepository.save(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(id);
	}

	@Override
	public void updateCustomer(long id, String address) {
		// TODO Auto-generated method stub
		Customer c = getCustomerByCusId(id);
		c.setAddress(address);
		customerRepository.save(c);
		
	}

}
