package com.springboot.bankingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.bankingApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value = "select e from Employee e where e.empId like ?1 and e.password like ?2")
	public Employee validateEmployee(long empid, String password);
	
	
}
