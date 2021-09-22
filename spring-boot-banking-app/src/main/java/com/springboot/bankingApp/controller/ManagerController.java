package com.springboot.bankingApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankingApp.service.ManagerService;

@Controller
@RequestMapping("/employee")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;
	
	@GetMapping("/manager")
	public ModelAndView showManagerPage() {
		System.out.println("Showing Manager Page......");
		return new ModelAndView("manager");
	}
	
}
