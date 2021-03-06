package com.springboot.bankingApp.service;

import java.util.List;

import com.springboot.bankingApp.dto.AddClerk;
import com.springboot.bankingApp.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByEmpId(long id);
	public Employee getEmployeeByUsername(String username);
	public void saveOrUpdateEmployee(AddClerk add);
	public void deleteEmployee(long id);
	public String getEmployeePassword(long empid);
	public Employee checkLogin(long empid, String password);
	public void updateClerkAddress(long id,String address);
}
