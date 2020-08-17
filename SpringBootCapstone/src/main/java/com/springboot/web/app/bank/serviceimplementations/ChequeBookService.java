package com.springboot.web.app.bank.serviceimplementations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.bank.model.Chequebook;
import com.springboot.web.app.bank.model.User;


@Service
public class ChequeBookService {
	
	@Autowired
	com.springboot.web.app.bank.dao.ChequeBookDao chequeBookDao;
	
	@Autowired
	com.springboot.web.app.bank.dao.MyRepo repo;

//	public Chequebook addchequebook(Chequebook chequebook, String mailid) {
//		User user = repo.findByMailid(chequebook.getUser().getId());
//		chequebook.setUser(user);
//		return chequeBookDao.save(chequebook);
//	}
	
	public Chequebook addchequebook(Chequebook chequebook)
	{
		User user =repo.findById(chequebook.getUser().getId());
		System.out.println(user.getId());
		chequebook.setUser(user);
		return chequeBookDao.save(chequebook);
	}
	
//	public Chequebook addchequebook(Chequebook chequebook, Long id)
//	{
//		User user = repo.findById(id);
//		chequebook.setUser(user);
//		return chequeBookDao.save(chequebook);
//	}
	
}
