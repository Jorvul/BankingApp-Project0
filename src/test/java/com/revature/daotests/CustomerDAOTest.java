package com.revature.daotests;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import com.revature.bank.Customer;
import com.revature.bank.daos.BankDAO;
import com.revature.bank.daos.BankPostgresDAO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class CustomerDAOTest {
	  private BankDAO dao = new BankPostgresDAO();
	  private static Customer customer;
//@Test
@BeforeAll	  
@Order(1)
	   void  createNewCustomerTest() {
		   Customer lp = new Customer(25, "Lewis Parker", 20000.00, "Checking Account", "Savings Account");
			dao.createCustomer(lp);
			CustomerDAOTest.customer = lp;
			Assertions.assertEquals(25, lp.getCustomerId());
	  }
//@Test
@Order(2)
void getAllCustomersTest() {
	List<Customer> allCustomers = new ArrayList<Customer>();
	List<Customer> noCustomers = new ArrayList<Customer>();
	allCustomers = dao.getCustomers();
	Assertions.assertNotEquals(noCustomers, allCustomers);
}

//@Test
@Order(3)
void getCustomerByIdTest() {
	Customer cus = new Customer(10, "Jorge",30000.00, "Checking Account", "Savings Account");
	dao.getCustomerById(10);
	CustomerDAOTest.customer = cus;
	Assertions.assertEquals(10, cus.getCustomerId());
}
//@Test
@Order(4)
void updateCustomerByIdTest() {
	Customer cus = new Customer(15, "Troy",25000.00,"Savings Account", "Checking Account");
	dao.updateCustomerById(cus, 15);
	CustomerDAOTest.customer= cus;
	Assertions.assertEquals(15, cus.getCustomerId());
}
//@Test
@Order(5)
void deleteCustomerTest() {
	Customer cus = new Customer(25,"Lewis Parker", 20000.00, "Checking Account", "Savings Account");
	dao.deleteCustomer(25);
	CustomerDAOTest.customer = cus;
	Assertions.assertEquals(25, cus.getCustomerId());
}
//@Test
@Order(6)
void createNewAccountTest() {
	Customer cus = new Customer(25,"Lewis Parker", 20000.00, "Checking Account", "Savings Account");
	dao.createAccountById(cus, 25);
	CustomerDAOTest.customer = cus;
	Assertions.assertEquals(25, cus.getCustomerId());
}
//@Test
@Order(7)
void getAccountByIdTest() {
	Customer cus = new Customer(25,"Lewis Parker", 20000.00, "Checking Account", "Savings Account");
	dao.getAccountForCustomerById(25, "Lewis");
	CustomerDAOTest.customer = cus;
	Assertions.assertEquals("Checking Account", cus.getAccountName());
}
	 
}
