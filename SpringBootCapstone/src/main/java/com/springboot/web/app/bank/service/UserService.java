package com.springboot.web.app.bank.service;

import java.util.List;
import java.util.Set;

import com.springboot.web.app.bank.model.User;
public interface UserService {
    User findByEmail(String email);
	User findByUsername(String name);
	User findByFullname(String name);
}
