package com.springboot.bankingApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping("/signin")
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

	@PostMapping("/signin")
	public ModelAndView validateEmployee(ModelMap model ,@ModelAttribute("employee-sign-in") Employee employee) {
		System.out.println("ValidATe Employee......");
		System.out.println(employee.getEmpId());
		if(employee.getEmpId()==1 && employee.getPassword().equals("123")) {
			return new ModelAndView("customer");
		}
		model.put("errorMsg","Please provide the correct UserId and Password!!");
		return new ModelAndView("index");

	}
}
