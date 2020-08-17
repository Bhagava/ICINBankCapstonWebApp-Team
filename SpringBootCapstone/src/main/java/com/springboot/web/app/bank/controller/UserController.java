package com.springboot.web.app.bank.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.bank.dao.MyRepo;
import com.springboot.web.app.bank.model.Admin;
import com.springboot.web.app.bank.model.PrimaryAccount;
import com.springboot.web.app.bank.model.SavingsAccount;
import com.springboot.web.app.bank.model.User;
import com.springboot.web.app.bank.service.UserService;
import com.springboot.web.app.bank.serviceimplementations.RegisterService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class UserController {

	
	private User user1;
	@Autowired
	RegisterService registerService;

	@Autowired
	UserService userService;
	
	@Autowired
	private MyRepo repo;
	

	
	@RequestMapping(path="/register", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User registerAddUser(@RequestBody User user)
	{
		User Obj;
		user.setStatus("enabled");
		Obj=registerService.addUser(user);
		System.out.println(Obj);
		return Obj;
	}
	
	
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public User doLogin(@RequestBody User user) throws Exception
	{
		String temperorymail = user.getMailid();
		String temperorypassword = user.getPassword();
		User Obj = null;
		
		if(temperorymail != null && temperorypassword != null )
		{
			User dbuser = repo.findByMailid(temperorymail);
			if(dbuser != null && dbuser.getStatus().equalsIgnoreCase("enabled"))
			{
				Obj = registerService.matchEmailPassword(temperorymail, temperorypassword);
		
			}
			else
			{
				throw new Exception("User is Blocked or User not Exist");
			}
		}
		return Obj;
	}
	
	
	@RequestMapping(path = "/admin", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public void doAdminLogin(@RequestBody Admin admin) throws Exception
	{
		String adminemail = admin.getEmailid();
		String adminpassword = admin.getPassword();
		
		if(adminemail.equals("admin") && adminpassword.equals("Admin@123"))
		{
			System.out.println("admin successfully login");
		}
		else
		{
			throw new Exception("credentials are wrong");
		}
		
		
	}
	
	@PostMapping("/home" )
	@CrossOrigin(origins = "http://localhost:4200")
	public List getHome(@RequestBody String email) {
		List<Object> accounts = new ArrayList<Object>();
		user1 = userService.findByEmail(email);
		System.out.println(user1);
        //model.addAttribute("savingsAccount", savingsAccount);
		PrimaryAccount primaryAccount = user1.getPrimaryAccount();
	    SavingsAccount savingsAccount = user1.getSavingsAccount();
	    //System.out.println(savingsAccount);
	    accounts.add(savingsAccount);
	    accounts.add(primaryAccount);
	    return accounts;
    }
	
	
	@RequestMapping(path = "/getuser", method = RequestMethod.GET)
	public List<User> getUserDetails()
	{
		return registerService.getUserDetails();
	}
		
}
