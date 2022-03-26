package com.revature.bank.daos;

import java.util.List;

import com.revature.bank.Customer;

public interface BankDAO {

	List<Customer>getCustomers();
	boolean createCustomer(Customer customer);
	List<Customer>getCustomerById(int c);
	Customer updateCustomerById(Customer customer, int id1);
	void deleteCustomer(int id);
	Customer createAccountById(Customer customer, int id);
}
