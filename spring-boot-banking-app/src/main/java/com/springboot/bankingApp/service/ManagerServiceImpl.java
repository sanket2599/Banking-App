package com.springboot.bankingApp.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.bankingApp.entity.Employee;
import com.springboot.bankingApp.entity.Manager;
import com.springboot.bankingApp.repository.ManagerRepository;

@Service
@Transactional
public class ManagerServiceImpl implements ManagerService{
	ManagerRepository managerRepository;
	
	@Autowired
	public ManagerServiceImpl(ManagerRepository managerRepository) {
		super();
		this.managerRepository = managerRepository;
	}


	@Override
	public void saveManager(Manager manager) {
		// TODO Auto-generated method stub
		managerRepository.save(manager);
	}


	@Override
	public Manager getManagerByUserName(String username) {
		// TODO Auto-generated method stub
		return managerRepository.validateManager(username);
	}
}
