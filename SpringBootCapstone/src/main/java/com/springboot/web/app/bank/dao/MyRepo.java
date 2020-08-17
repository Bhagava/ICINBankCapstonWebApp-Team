package com.springboot.web.app.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.web.app.bank.model.User;

@Repository
public interface MyRepo extends JpaRepository<User, Integer>{
	User findByMailid(String mailid);
	User findByMailidAndPassword(String mailid, String password);
	User findById(Long id);

//	@Query("FROM User where mailid =?1")
//	User findByMailid(String mailid);
	//User findByMailid(String mailid);
	User findByPhonenumber(Long phonenumber);
	User deleteById(Long id);
//	User findByMailid(String mailid);
//	User findByMailidAndPassword(String mailid, String password);

}
