package com.springboot.web.app.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.bank.model.Chequebook;

@RestController
public class ChequebookController {
	
	@Autowired
	com.springboot.web.app.bank.serviceimplementations.ChequeBookService chequeBookService;
	
	
	@RequestMapping(path = "/chequebook", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public com.springboot.web.app.bank.model.Chequebook chequerequest(@RequestBody Chequebook chequebook)
	{
		return chequeBookService.addchequebook(chequebook);
	}
	
	
//	@RequestMapping(path = "/chequebook/{mailid}", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Chequebook chequerequest(@RequestBody Chequebook chequebook, @PathVariable("mailid") String mailid)
//	{
//		return chequeBookService.addchequebook(chequebook, mailid);
//	}
	
	
	

	
	
}
