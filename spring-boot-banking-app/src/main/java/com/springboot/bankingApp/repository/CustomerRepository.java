package com.springboot.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bankingApp.entity.Customer;
import com.springboot.bankingApp.entity.Employee;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	

}
