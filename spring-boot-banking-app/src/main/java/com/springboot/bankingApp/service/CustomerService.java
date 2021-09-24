package com.springboot.bankingApp.service;

import java.util.List;

import com.springboot.bankingApp.dto.AddCustomer;
import com.springboot.bankingApp.entity.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getCustomerByCusId(long id);
	public void saveOrUpdateCustomer(AddCustomer addCustomer);
	public void updateCustomer(long id,String address);
	public void deleteCustomer(long id);
	public void transfer(long fromId,long toId,long amount);
	public void deposit(long toId,long amount);
	public void withdraw(long fromId,long amount);
}
