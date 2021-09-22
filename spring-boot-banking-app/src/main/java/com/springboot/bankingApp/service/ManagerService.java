package com.springboot.bankingApp.service;

import com.springboot.bankingApp.entity.Manager;

public interface ManagerService {
	public Manager getManagerByUserName(String username);
	public void saveManager(Manager manager);
}
