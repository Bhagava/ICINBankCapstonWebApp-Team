package com.springboot.web.app.bank.serviceimplementations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.bank.customexceptions.AccountNotFoundException;
import com.springboot.web.app.bank.dao.PersonalTransactionDao;
import com.springboot.web.app.bank.dao.PrimaryAccountDao;
import com.springboot.web.app.bank.model.AccountHandler;
import com.springboot.web.app.bank.model.PersonalTransaction;
import com.springboot.web.app.bank.model.PrimaryAccount;
import com.springboot.web.app.bank.model.User;
import com.springboot.web.app.bank.service.PrimaryAccountService;
import com.springboot.web.app.bank.service.TransactionService;
import com.springboot.web.app.bank.service.UserService;

@Service
public class PrimaryAccountServiceImpl implements PrimaryAccountService {

	 @Autowired
	 private PrimaryAccountDao primaryAccountDao;
	   
	 @Autowired
	 private UserService userService;
	 
	 @Autowired
	 private TransactionService transactionService;
	 
	 @Autowired
	 private PersonalTransactionDao personalTransactionDao;
	 
     private static int nextAccountNumber = 22113344;
     
     
	@Override
	public PrimaryAccount createPrimaryAccount() {
		PrimaryAccount primaryAccount = new PrimaryAccount();
        primaryAccount.setAccountBalance(new Long(0));
        nextAccountNumber += 1;
        primaryAccount.setAccountNumber(nextAccountNumber);
        primaryAccountDao.save(primaryAccount);
        return primaryAccountDao.findByAccountNumber(primaryAccount.getAccountNumber());
	}

	@Override
	public List<PrimaryAccount> getAllPrimaryAccounts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deposit(Integer accNo, Long amount) {
		//System.out.println(accNo);
		
      	PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accNo);
      	Long prevBal = primaryAccount.getAccountBalance();
      	Long newBal = primaryAccount.getAccountBalance() + amount;
        primaryAccount.setAccountBalance(newBal );
        primaryAccountDao.save(primaryAccount);
        
        Date date = new Date();
        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal , newBal, "Deposit" ,"Primary");
        personalTransactionDao.save(personalTransaction);		
	}

	@Override
	public String withdraw(Integer accNo, Long amount){
		PrimaryAccount primaryAccount = primaryAccountDao.findByAccountNumber(accNo);
		
		if(primaryAccount.getAccountBalance()>=amount) {
			Long prevBal = primaryAccount.getAccountBalance();
			Long newBal = primaryAccount.getAccountBalance() - amount;
	        primaryAccount.setAccountBalance(newBal);
	        primaryAccountDao.save(primaryAccount);
	        Date date = new Date();
	        PersonalTransaction personalTransaction = new PersonalTransaction(accNo ,date, prevBal, newBal, "Withdraw" ,"Primary");
	        personalTransactionDao.save(personalTransaction);

	        return "Done";
		} else {
			return "Insufficient Balance";
		}

		
	}

	@Override
	public PrimaryAccount getAccount(int accNo) {
		return primaryAccountDao.findByAccountNumber(accNo);
	}


    @Override
    public Long retrieveAccountBalance(long accountId) {
        Optional<PrimaryAccount> account = primaryAccountDao.findById(accountId);
        if (!account.isPresent()) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountId));
        }
        return account.get().getAccountBalance();
    }
    
    
    @Override
    public AccountHandler retrieveAccountBalanceAndListOfTransactions(int accountno) {

        PrimaryAccount account = primaryAccountDao.findByAccountNumber(accountno);
        if (account==null) {
            throw new AccountNotFoundException(
                  String.format("Account %s not found.", accountno));
        }
        AccountHandler accountSnapshot =
                new AccountHandler(
                        account.getAccountNumber(), 
                        account.getAccountBalance(), 
                        transactionService.retrieveTransactionsForAccount(accountno));
        return accountSnapshot;
    
    }



}
