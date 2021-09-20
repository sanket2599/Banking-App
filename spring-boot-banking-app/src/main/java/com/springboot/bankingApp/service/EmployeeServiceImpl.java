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

	@Autowired
	EmployeeRepository employeeRepository;
	
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

}
