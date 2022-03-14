package com.revature.mytests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.revature.bank.CheckingAccount;
import com.revature.bank.Customer;


public class CheckingAccountTest {
	Customer p = new Customer("Jorge", 30000.00);
	
	@Test
	public void testBalance() {
		double result = p.depositFunds(2000.00);
		Assertions.assertEquals(32000.00, result);
	}
	

}
