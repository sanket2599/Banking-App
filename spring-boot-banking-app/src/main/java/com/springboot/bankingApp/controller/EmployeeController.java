package com.springboot.bankingApp.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankingApp.dto.AddCustomer;
import com.springboot.bankingApp.dto.Deposit;
import com.springboot.bankingApp.dto.Transfer;
import com.springboot.bankingApp.dto.Withdraw;
import com.springboot.bankingApp.entity.Customer;
import com.springboot.bankingApp.entity.Employee;
import com.springboot.bankingApp.entity.Manager;
import com.springboot.bankingApp.service.CustomerService;
import com.springboot.bankingApp.service.EmployeeService;
import com.springboot.bankingApp.service.ManagerService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;

	@Autowired
	CustomerService customerService;
	
	@Autowired
	ManagerService managerService;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/signin")
	public String showHomePage() {
		System.out.println("Showing Home Page......");
		return "index";
	}

	@PostMapping("/signin")
	public String validateEmployee(ModelMap model, @ModelAttribute("employee-sign-in") Employee employee) {
		System.out.println("ValidATe Employee......");
		System.out.println(employee.getUsername());
		Employee details = employeeService.getEmployeeByUsername(employee.getUsername());
		System.out.println("Details............." + details);
		if (details != null) {
			if (employee.getUsername().equals(details.getUsername())
					&& employee.getPassword().equals(details.getPassword())
					&& details.getDesignation().equals("Clerk")) {
				return "redirect:customers";
			}
		}
		else
		{
			Manager managerDetails = managerService.getManagerByUserName(employee.getUsername());
			if (employee.getUsername().equals(managerDetails.getUsername())
					&& employee.getPassword().equals(managerDetails.getPassword())
					&& managerDetails.getDesignation().equals("Manager")) {
				return "redirect:employees-customers";
			}
		}
		model.put("errorMsg", "Please provide the correct UserId and Password!!");
		return "index";

	}

	@GetMapping("/signup")
	public ModelAndView showSignUpPage() {
		System.out.println("Showing Sign Up Page......");
		return new ModelAndView("signup");
	}

	@PostMapping("/signup")
	public ModelAndView validateSignup(ModelMap model, @ModelAttribute("employee-sign-up") Employee employee) {
		System.out.println("ValidATe Signup......");
		System.out.println(employee.getDesignation());
		return new ModelAndView("index");

	}

	@GetMapping("/clerks")
	public String showAllClerks(ModelMap map) {
		System.out.println("Showing Clerks list.......");
		map.addAttribute("employeeList", employeeService.getAllEmployee());
		return "clerk";
	}

	@GetMapping("/customers")
	public String showAllCustomers(ModelMap map) {
		System.out.println("Showing Customer list.......");
		map.addAttribute("customerList", customerService.getAllCustomers());
		return "customer";
	}

	@GetMapping("/update/{eid}")
	public String updateCustomer(ModelMap map, @PathVariable long eid) {
		System.out.println("Showing Customer list.......");
		map.addAttribute("custList", customerService.getCustomerByCusId(eid));
		return "customerUpdate";
	}

	@PostMapping("/update/{eid}")
	public String updateCustomerDb(ModelMap map, @ModelAttribute("employee-update") Customer c) {
		System.out.println("Updating Customer ID number-......." + c.getCusId());
		customerService.updateCustomer(c.getCusId(), c.getAddress());
		return "redirect:../customers";
	}

	@GetMapping("/delete/{eid}")
	public String deleteCustomer(ModelMap map, @PathVariable long eid) {
		System.out.println("Deleting Customer list.......");
		customerService.deleteCustomer(eid);
		return "redirect:../customers";
	}

	@GetMapping("/customers/transfer")
	public String transferToAccount(ModelMap map) {
		System.out.println("Transfer Page.......");
		map.addAttribute("transfer", new Transfer());
		return "transfer";
	}

	@PostMapping("/customers/transfer")
	public String transferTo(@Valid @ModelAttribute(value = "transfer") Transfer transferRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			return "customers/transfer";
		}
		customerService.transfer(transferRequest.getFromAccId(), transferRequest.getToAccId(),
				transferRequest.getAmount());
		return "redirect:../customers";
	}

	@GetMapping("/customers/deposit")
	public String depositToAccount(ModelMap map) {
		System.out.println("Deposit Page.......");
		map.addAttribute("deposit", new Deposit());
		return "deposit";
	}

	@PostMapping("/customers/deposit")
	public String depositTo(@Valid @ModelAttribute(value = "deposit") Deposit deposit, BindingResult result) {
		if (result.hasErrors()) {
			return "customers/deposit";
		}
		customerService.deposit(deposit.getToAccId(), deposit.getAmount());
		return "redirect:../customers";
	}

	@GetMapping("/customers/withdraw")
	public String withdrawFromAccount(ModelMap map) {
		System.out.println("Withdraw Page.......");
		map.addAttribute("withdraw", new Withdraw());
		return "withdraw";
	}

	@PostMapping("/customers/withdraw")
	public String depositTo(@Valid @ModelAttribute(value = "withdraw") Withdraw withdraw, BindingResult result) {
		if (result.hasErrors()) {
			return "customers/withdraw";
		}
		customerService.withdraw(withdraw.getFromAccId(), withdraw.getAmount());
		return "redirect:../customers";
	}

	@GetMapping("/customers/addCustomer")
	public String addCustomer(ModelMap map) {
		System.out.println("Add Customer Page.......");
		map.addAttribute("addCustomer", new AddCustomer());
		return "addCustomer";
	}

	@PostMapping("/customers/addCustomer")
	public String addCustomer(@Valid @ModelAttribute(value = "addCustomer") AddCustomer addCustomer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "customers/addCustomer";
		}
		customerService.saveOrUpdateCustomer(addCustomer);
		return "redirect:../customers";
	}

}
