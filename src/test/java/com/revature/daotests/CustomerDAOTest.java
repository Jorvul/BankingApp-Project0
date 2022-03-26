package com.revature.daotests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

import com.revature.bank.Customer;
import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomerDAOTest {
	  private BankDAO dao = new BankPostgresDAO();
	  private static Customer customer = null;
//@Test
//@Order(1)
//	   void  createNewCustomerTest() {
//		   Customer lp = new Customer(25, "Lewis Parker", 20000.00, "Checking Account");
//			dao.createCustomer(lp);
//			CustomerDAOTest.customer = lp;
//			Assertions.assertEquals(25, lp.getCustomerId(), 20000.00, "CheckingAccount");
//	  }
//@Test
//@Order(2)
//void getAllCustomersTest() {
//	List<Customer> allCustomers = new ArrayList<Customer>();
//	List<Customer> noCustomers = new ArrayList<Customer>();
//	allCustomers = dao.getCustomers();
//	Assertions.assertNotEquals(noCustomers, allCustomers);
//}
	  
	 
}
