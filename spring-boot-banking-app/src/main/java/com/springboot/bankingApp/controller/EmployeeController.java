package com.springboot.bankingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankingApp.entity.Employee;
import com.springboot.bankingApp.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/index" )
	public ModelAndView showHomePage() {
		System.out.println("Showing Home Page......");
		return new ModelAndView("index"); 
	}
	
	@GetMapping("/employees")
	public ModelAndView showAllEmployees() {
		System.out.println("Showing Employee list.......");
		ModelAndView mav = new ModelAndView("employees");
		List<Employee> employeeList = employeeService.getAllEmployee();
		mav.addObject("employeeList", employeeList); // Set the attribute as "employeeList"
		return mav;
	}
}
