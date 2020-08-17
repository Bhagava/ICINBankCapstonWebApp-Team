package com.springboot.web.app.bank.service;

import java.security.Principal;
import java.util.List;

import com.springboot.web.app.bank.model.PrimaryAccount;
import com.springboot.web.app.bank.model.SavingsAccount;

public interface SavingsAccountService {
	
	public SavingsAccount createSavingsAccount();
	public List<SavingsAccount> getAllSavingsAccounts();
	public void deposit(Integer accNo, Long amount);
	public String withdraw(Integer accNo, Long amount);
    public SavingsAccount getAccount(int accNo);
	Long retrieveAccountBalance(long accountId);
}
