package com.springboot.bankingApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.bankingApp.entity.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Long>{
	
	@Query(value = "select m from Manager m where m.username like ?1")
	public Manager validateManager(String username);
}
