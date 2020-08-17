package com.springboot.web.app.bank.dao;


import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.bank.model.SavingsAccount;


public interface SavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber (int accountNumber);

}
