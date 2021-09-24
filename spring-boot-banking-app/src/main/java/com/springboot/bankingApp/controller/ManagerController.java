package com.springboot.bankingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankingApp.service.CustomerService;
import com.springboot.bankingApp.service.EmployeeService;
import com.springboot.bankingApp.service.ManagerService;

@Controller
@RequestMapping("/employee")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees-customers")
	public String showAllEmployees(ModelMap map) {
		System.out.println("Showing Employees list.......");
		map.addAttribute("customerList", customerService.getAllCustomers());
		map.addAttribute("employeeList",employeeService.getAllEmployee());
		System.out.println(employeeService.getAllEmployee());
		System.out.println(customerService.getAllCustomers());
		return "employee-customer";
	}
}
