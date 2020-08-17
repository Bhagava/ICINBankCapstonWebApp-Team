package com.springboot.web.app.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.springboot.web.app.bank.model.PrimaryAccount;

public interface PrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber (int accountNumber);

}
