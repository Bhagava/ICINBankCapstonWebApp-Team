package com.springboot.web.app.bank.service;

import java.security.Principal;
import java.util.List;

import com.springboot.web.app.bank.model.AccountHandler;
import com.springboot.web.app.bank.model.PrimaryAccount;

public interface PrimaryAccountService {
	public PrimaryAccount createPrimaryAccount();
	public List<PrimaryAccount> getAllPrimaryAccounts();
	public String withdraw(Integer accNo, Long amount);
	public void deposit(Integer accNo, Long amount);
	public PrimaryAccount getAccount(int accNo);
	/**
     * Finds account balance for given account
     * @param accountId Unique account ID
     * @return Available balance for account
     */
    public Long retrieveAccountBalance(long accountId);
    
    /**
     * Finds account balance and list of transactions for given account
     * @param accountId Unique account ID
     * @return Available balance for account
     */
    public AccountHandler retrieveAccountBalanceAndListOfTransactions(int accountno);
}
