package com.springboot.web.app.bank.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.web.app.bank.model.Chequebook;



@Repository
public interface ChequeBookDao extends JpaRepository<com.springboot.web.app.bank.model.Chequebook, Long> {
		
	@Query("select c from Chequebook c where user.status = 'enabled'")
	List<Chequebook> fetchAllActiveChequebooks();
	
}
