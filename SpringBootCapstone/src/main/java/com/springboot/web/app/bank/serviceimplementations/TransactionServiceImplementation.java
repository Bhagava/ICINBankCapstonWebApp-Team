package com.springboot.web.app.bank.serviceimplementations;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.web.app.bank.customexceptions.AccountNotFoundException;
import com.springboot.web.app.bank.customexceptions.InvalidAccountException;
import com.springboot.web.app.bank.dao.PrimaryAccountDao;
import com.springboot.web.app.bank.dao.TransactionRepository;
import com.springboot.web.app.bank.model.AccountHandler;
import com.springboot.web.app.bank.model.PrimaryAccount;
import com.springboot.web.app.bank.model.Transaction;
import com.springboot.web.app.bank.service.TransactionService;


@Service
public class TransactionServiceImplementation implements TransactionService{
    
    @Autowired
    private TransactionRepository transactionRepository;
    
    @Autowired
    private PrimaryAccountDao primaryAccountDao;

    @Override
    public List<Transaction> retrieveTransactionsForAccount(int accountNumber) {
        
        return transactionRepository.retrieveTransactionsForAccount(accountNumber);
    }
    
    @Override
    public void transferMoney(Transaction transaction) {

       PrimaryAccount sourceAccount = 
        		primaryAccountDao.findByAccountNumber(transaction.getSourceAccountnumber());
        PrimaryAccount destinationAccount = 
        		primaryAccountDao.findByAccountNumber(transaction.getDestinationAccountnumber());
        if (sourceAccount==null || destinationAccount==null) {
            throw new InvalidAccountException(
                    "Invalid source account " + "or destination account ");
        }

        transaction.runValidationTests(
                sourceAccount, destinationAccount);

        Long transactionAmount = 
                transaction.getTransactionAmount();
        sourceAccount.setAccountBalance(
                sourceAccount.getAccountBalance() - transactionAmount); // subtraction logic
        destinationAccount.setAccountBalance(
                destinationAccount.getAccountBalance() + transactionAmount); // addition logic

        transactionRepository.save(transaction);

        primaryAccountDao.save(sourceAccount);
        primaryAccountDao.save(destinationAccount);

    }

	@Override
	public int retreiveAccountNumber(Long id) {
		Optional<PrimaryAccount> account =  primaryAccountDao.findById(id);
		int accNo = account.get().getAccountNumber();
		return accNo;
	}

	
	
    

}
