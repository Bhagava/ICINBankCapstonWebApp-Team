package com.springboot.web.app.bank.controller;



	
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.web.app.bank.dao.ChequeBookDao;
import com.springboot.web.app.bank.dao.MyRepo;
import com.springboot.web.app.bank.model.Chequebook;
import com.springboot.web.app.bank.model.User;

@RestController
public class AdminController {
	@Autowired
	MyRepo repo;
		
	@Autowired
	ChequeBookDao chequebookdao;
		
		
		
	@RequestMapping("/viewusers")
	@CrossOrigin(origins = "http://localhost:4200")
	@JsonIgnore
	public List<User> viewusers(){
		return repo.findAll();
		
	}
		
		
//	@RequestMapping(value = "/getcheckbooks", produces = "application/json")
//	@CrossOrigin(origins = "http://localhost:4200")

	@RequestMapping(value = "/getcheckbooks")
	public List<Chequebook> viewAllChequebooks()
	{
		return chequebookdao.fetchAllActiveChequebooks();
	}
		
		
//		@DeleteMapping("/lockuser/{id}")
//		@CrossOrigin(origins = "http://localhost:4200")
//	    public User lockuser(@PathVariable(value = "id") Long id)  {
//			return repo.deleteById(id);
//	    }
		
		
		
	@PutMapping("/lockuser/{id}")
	@CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<User> lockuser(@PathVariable(value = "id") Long id)  {
		System.out.println("1");
        User user = repo.findById(id);
        System.out.println("0");
        user.setStatus("User Blocked");
        System.out.println("12");
        System.out.println(user.getStatus());
        User updateduser = repo.save(user);
        return ResponseEntity.ok(updateduser);
    }
		
		
		
}
