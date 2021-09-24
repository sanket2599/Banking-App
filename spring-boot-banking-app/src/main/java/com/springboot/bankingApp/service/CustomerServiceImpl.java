package com.springboot.bankingApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingApp.dto.AddCustomer;
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
	public void saveOrUpdateCustomer(AddCustomer add) {
		// TODO Auto-generated method stub
		
		customerRepository.save(new Customer(add.getName(),add.getAddress(),add.getBalance(),add.getUpdate(),add.getDelete()));
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

	@Override
	public void transfer(long fromId, long toId, long amount) {
		// TODO Auto-generated method stub
		Customer c1=getCustomerByCusId(fromId);
		c1.setBalance((c1.getBalance()-amount));
		customerRepository.save(c1);
		
		Customer c2=getCustomerByCusId(toId);
		c2.setBalance(c2.getBalance()+amount);
		customerRepository.save(c2);
	}

	@Override
	public void deposit(long toId, long amount) {
		// TODO Auto-generated method stub
		Customer c1=getCustomerByCusId(toId);
		c1.setBalance((c1.getBalance()+amount));
		customerRepository.save(c1);
	}

	@Override
	public void withdraw(long fromId, long amount) {
		// TODO Auto-generated method stub
		Customer c1=getCustomerByCusId(fromId);
		c1.setBalance((c1.getBalance()-amount));
		customerRepository.save(c1);
	}

}
