package com.springboot.bankingApp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingApp.entity.Employee;
import com.springboot.bankingApp.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

	
	EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeByEmpId(long id) {
		// TODO Auto-generated method stub
		return employeeRepository.getById(id);
	}

	@Override
	public void saveOrUpdateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepository.deleteById(id);
	}

	@Override
	public String getEmployeePassword(long empid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee checkLogin(long empid, String password) {
		// TODO Auto-generated method stub
		return employeeRepository.validateEmployee(empid, password);
	}

	@Override
	public Employee getEmployeeByUsername(String username) {
		// TODO Auto-generated method stub
		return employeeRepository.validateEmp(username);
	}

	@Override
	public void updateClerkAddress(long id, String address) {
		// TODO Auto-generated method stub
		Employee e=getEmployeeByEmpId(id);
		e.setAddress(address);
		employeeRepository.save(e);
		
	}

}
