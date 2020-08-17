package com.springboot.web.app.bank.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.web.app.bank.model.PersonalTransaction;

public interface PersonalTransactionDao extends JpaRepository<PersonalTransaction, Integer>{

}
