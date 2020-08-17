


package com.springboot.web.app.bank.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.web.app.bank.customexceptions.AccountNotFoundException;
import com.springboot.web.app.bank.dao.PrimaryAccountDao;
import com.springboot.web.app.bank.model.AccountHandler;
import com.springboot.web.app.bank.model.PrimaryAccount;
import com.springboot.web.app.bank.model.SavingsAccount;
import com.springboot.web.app.bank.model.Transaction;
import com.springboot.web.app.bank.model.TransferMoneyPrimarySavings;
import com.springboot.web.app.bank.service.PrimaryAccountService;
import com.springboot.web.app.bank.service.SavingsAccountService;
import com.springboot.web.app.bank.service.TransactionService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class AccountController {
	
	@Autowired
	private PrimaryAccountService primaryAccountService;
	
	@Autowired
	private SavingsAccountService savingsAccountService;
	
	@Autowired
	private PrimaryAccountDao primaryAccountDao;
	
	@PostMapping("/deposit")
	@CrossOrigin(origins = "http://localhost:4200")
    public Object deposit(@RequestBody TransferMoneyPrimarySavings moneyPrimarySavings) {
		String accType = moneyPrimarySavings.getAccType();
		String accNo = moneyPrimarySavings.getAccNo();
		String amount = moneyPrimarySavings.getAmount();
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		if(accType.equalsIgnoreCase("Primary")) {
			System.out.println(accType);
			primaryAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
		}	
		else {
			System.out.println(accType);
			savingsAccountService.deposit(Integer.parseInt(accNo) , Long.parseLong(amount));
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
		}
			
    }
	
	@PostMapping("/withdraw" )
	@CrossOrigin(origins = "http://localhost:4200")
    public Object withdraw(@RequestBody TransferMoneyPrimarySavings moneyPrimarySavings) {
		//System.out.println(accNo);
		//System.out.println(accType.getClass());
		String accType = moneyPrimarySavings.getAccType();
		String accNo = moneyPrimarySavings.getAccNo();
		String amount = moneyPrimarySavings.getAmount();
		
		if(accType.equals("Primary")) {
			System.out.println(accType);
			String val = primaryAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			PrimaryAccount primaryAcc = primaryAccountService.getAccount(Integer.parseInt(accNo));
			return primaryAcc;
			}
			else {
				return "Insufficient Balance";
			}
		}	
		else {
			System.out.println(accType);
			String val = savingsAccountService.withdraw(Integer.parseInt(accNo) , Long.parseLong(amount));
			if(val.equals("Done")) {
			SavingsAccount savingsAcc = savingsAccountService.getAccount(Integer.parseInt(accNo));
			return savingsAcc;
			}
			else
			{
				return "Insufficient Balance";
			}
		}		
    }
	
	@Autowired
    private TransactionService transactionService;
    
    @GetMapping(path="/accounts")
    @CrossOrigin(origins = "http://localhost:4200")
    public Iterable<PrimaryAccount> retrieveAllAccounts() {
        return primaryAccountDao.findAll();
    }

    @GetMapping(path = "/accounts/{accountId}/balance")
    @CrossOrigin(origins = "http://localhost:4200")
    public Long retrieveAccountBalance(@PathVariable int accountNumber) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountNumber);
//        if (!account.isPresent()) {
//            throw new AccountNotFoundException(
//                  String.format("Account %s not found.", accountId));
//        }
        return account.getAccountBalance();
    }
    
 
    @GetMapping(path = "/accounts/{accountId}/transactions")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Transaction> retrieveAccountTransactions(@PathVariable int accountId) {
        //PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountId);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        return transactionService.retrieveTransactionsForAccount(accountId);
    }
    
    @GetMapping(path = "/accounts/{accountId}/snapshot")
    @CrossOrigin(origins = "http://localhost:4200")
    public AccountHandler retrieveAccountBalanceAndListOfTransactions(
            @PathVariable int accountNo) {
        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountNo);
		/*
		 * if (!account.isPresent()) { throw new AccountNotFoundException(
		 * String.format("Account %s not found.", accountId)); }
		 */
        AccountHandler accountSnapshot =
                new AccountHandler(
                        account.getAccountNumber(), 
                        account.getAccountBalance(), 
                        transactionService.retrieveTransactionsForAccount(accountNo));
        return accountSnapshot;
    }

}
