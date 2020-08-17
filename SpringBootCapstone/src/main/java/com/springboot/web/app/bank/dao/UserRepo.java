package com.springboot.web.app.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.bank.model.User;

public interface UserRepo extends CrudRepository<User, Long> {
	User findByMailid(String mailid);

	User findByFullname(String name);
}
