package com.revature.daotests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Assertions;

import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomerDAOTest {
	  private BankDAO dao = new BankPostgresDAO();

	  
	 
}
