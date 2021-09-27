package com.springboot.bankingApp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bankingApp.dto.AddClerk;
import com.springboot.bankingApp.dto.AddCustomer;
import com.springboot.bankingApp.dto.Deposit;
import com.springboot.bankingApp.dto.Transfer;
import com.springboot.bankingApp.dto.Withdraw;
import com.springboot.bankingApp.entity.Customer;
import com.springboot.bankingApp.entity.Employee;
import com.springboot.bankingApp.repository.EmployeeRepository;
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
	
	//////////////Loading Manager View/////////////////////////
	
	@GetMapping("/employees-customers")
	public String showAllEmployees(ModelMap map) {
		System.out.println("Showing Employees list.......");
		map.addAttribute("customerList", customerService.getAllCustomers());
		map.addAttribute("employeeList",employeeService.getAllEmployee());
		System.out.println(employeeService.getAllEmployee());
		System.out.println(customerService.getAllCustomers());
		return "employee-customer";
	}
	
	/////////////////////////////////////////////////////
	
///////////	Updating Customer and Clerk Table/////////////////////////
	
	@GetMapping("/customer/update/{eid}")
	public String updateCustomer(ModelMap map, @PathVariable long eid) {
		System.out.println("Showing Customer list.......");
		map.addAttribute("custList", customerService.getCustomerByCusId(eid));
		return "customerUpdate";
	}

	@PostMapping("/customer/update/{eid}")
	public String updateCustomerDb(ModelMap map, @ModelAttribute("employee-update") Customer c) {
		System.out.println("Updating Customer ID number-......." + c.getCusId());
		customerService.updateCustomer(c.getCusId(), c.getAddress());
		return "redirect:../employees-customers";
	}
	
	@GetMapping("/clerk/update/{eid}")
	public String updateClerk(ModelMap map, @PathVariable long eid) {
		System.out.println("Showing Clerk list.......");
		map.addAttribute("employeeList", employeeService.getEmployeeByEmpId(eid));
		return "clerkUpdate";
	}
	
	@PostMapping("/clerk/update/{eid}")
	public String updateClerkDb(ModelMap map, @ModelAttribute("clerk-update") Employee e) {
		System.out.println("Updating Clerk ID number-......." + e.getEmpId());
		employeeService.updateClerkAddress(e.getEmpId(),e.getAddress());
		return "redirect:../../employees-customers";
	}
	
////////////////////////////////////////////////////////////////////////////////
	
	/////////////Deleting Clerk and Customer//////////////////////////

	@GetMapping("/customer/delete/{eid}")
	public String deleteCustomer(ModelMap map, @PathVariable long eid) {
		System.out.println("Deleting Customer list.......");
		customerService.deleteCustomer(eid);
		return "redirect:../../employees-customers";
	}
	
	@GetMapping("/clerk/delete/{eid}")
	public String deleteClerk(ModelMap map, @PathVariable long eid) {
		System.out.println("Deleting Clerk list.......");
		employeeService.deleteEmployee(eid);
		return "redirect:../../employees-customers";
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/manager/transfer")
	public String transferToAccount(ModelMap map) {
		System.out.println("Transfer Page.......");
		map.addAttribute("transfer", new Transfer());
		return "transfer";
	}
	

	@PostMapping("/manager/transfer")
	public String transferTo(@Valid @ModelAttribute(value = "transfer") Transfer transferRequest,
			BindingResult result) {
		if (result.hasErrors()) {
			return "manager/transfer";
		}
		customerService.transfer(transferRequest.getFromAccId(), transferRequest.getToAccId(),
				transferRequest.getAmount());
		return "redirect:../employees-customers";
	}

	@GetMapping("/manager/deposit")
	public String depositToAccount(ModelMap map) {
		System.out.println("Deposit Page.......");
		map.addAttribute("deposit", new Deposit());
		return "deposit";
	}

	@PostMapping("/manager/deposit")
	public String depositTo(@Valid @ModelAttribute(value = "deposit") Deposit deposit, BindingResult result) {
		if (result.hasErrors()) {
			return "manager/deposit";
		}
		customerService.deposit(deposit.getToAccId(), deposit.getAmount());
		return "redirect:../employees-customers";
	}

	@GetMapping("/manager/withdraw")
	public String withdrawFromAccount(ModelMap map) {
		System.out.println("Withdraw Page.......");
		map.addAttribute("withdraw", new Withdraw());
		return "withdraw";
	}

	@PostMapping("/manager/withdraw")
	public String depositTo(@Valid @ModelAttribute(value = "withdraw") Withdraw withdraw, BindingResult result) {
		if (result.hasErrors()) {
			return "manager/withdraw";
		}
		customerService.withdraw(withdraw.getFromAccId(), withdraw.getAmount());
		return "redirect:../employees-customers";
	}

	@GetMapping("/manager/addCustomer")
	public String addCustomer(ModelMap map) {
		System.out.println("Add Customer Page.......");
		map.addAttribute("addCustomer", new AddCustomer());
		return "addCustomer";
	}

	@PostMapping("/manager/addCustomer")
	public String addCustomer(@Valid @ModelAttribute(value = "addCustomer") AddCustomer addCustomer,
			BindingResult result) {
		if (result.hasErrors()) {
			return "manager/addCustomer";
		}
		customerService.saveOrUpdateCustomer(addCustomer);
		return "redirect:../employees-customers";
	}
	
	@GetMapping("/manager/addClerk")
	public String addClerk(ModelMap map) {
		System.out.println("Add Clerk.. Page.......");
		map.addAttribute("addClerk", new AddClerk());
		return "addClerk";
	}

	@PostMapping("/manager/addClerk")
	public String addClerk(@Valid @ModelAttribute(value = "addClerk") AddClerk addClerk,
			BindingResult result) {
		if (result.hasErrors()) {
			return "manager/addClerk";
		}
		employeeService.saveOrUpdateEmployee(addClerk);
		return "redirect:../employees-customers";
	}

}
