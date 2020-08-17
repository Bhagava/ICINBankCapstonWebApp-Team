package com.springboot.web.app.bank.serviceimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.bank.dao.MyRepo;
import com.springboot.web.app.bank.model.User;
import com.springboot.web.app.bank.service.PrimaryAccountService;
import com.springboot.web.app.bank.service.SavingsAccountService;


@Service
public class RegisterService {
	
	@Autowired
	MyRepo repo;
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private PrimaryAccountService primaryAccountService; 
		
	
	public User addUser(User user)
	{
		user.setPrimaryAccount(primaryAccountService.createPrimaryAccount());
        user.setSavingsAccount(savingsAccountService.createSavingsAccount());
        return repo.save(user);
	}
	
	public User matchEmailPassword(String mailid, String password)
	{
		return repo.findByMailidAndPassword(mailid, password);
	}
	
	public List<User> getUserDetails() {
		return repo.findAll();
	}
	
}
