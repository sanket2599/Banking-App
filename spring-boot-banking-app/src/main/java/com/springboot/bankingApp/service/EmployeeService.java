package com.springboot.bankingApp.service;

import java.util.List;

import com.springboot.bankingApp.entity.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByEmpId(long id);
	public void saveOrUpdateEmployee(Employee employee);
	public void deleteEmployee(long id);
	public String getEmployeePassword(long empid);
	public Employee checkLogin(long empid, String password);
}
