package com.springboot.bankingApp.service;

import java.util.List;

import com.springboot.bankingApp.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerByCusId(long id);
	public void saveOrUpdateCustomer(Customer customer);
	public void deleteCustomer(long id);
	
}
