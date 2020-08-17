package com.springboot.web.app.bank.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.web.app.bank.customexceptions.InvalidTransactionException;
import com.springboot.web.app.bank.model.Transaction;
import com.springboot.web.app.bank.service.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
    
   //transfer between 2 accounts
    
    @PostMapping(path = "/transfer")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object transferMoney(@RequestBody Transaction transaction) {

    	  transactionService.transferMoney(transaction);
         
          return transaction;
        

    }
}
