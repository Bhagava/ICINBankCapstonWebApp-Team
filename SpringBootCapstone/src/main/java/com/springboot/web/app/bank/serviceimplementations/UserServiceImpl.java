package com.springboot.web.app.bank.serviceimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.bank.dao.UserRepo;
import com.springboot.web.app.bank.model.User;
import com.springboot.web.app.bank.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	 
	 @Autowired
	 private UserRepo userRepo;
	 
	 public User findByEmail(String email) {
	        return userRepo.findByMailid(email);
	    }

	@Override
	public User findByUsername(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByFullname(String name) {
		return userRepo.findByFullname(name);
	}
}
