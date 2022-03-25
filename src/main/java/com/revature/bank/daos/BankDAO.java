package com.revature.bank.daos;

import java.util.List;

import com.revature.bank.Customer;

public interface BankDAO {

	List<Customer>getCustomers();
	boolean createCustomer(Customer customer);
	List<Customer>getCustomerById(int c);
	//List<Customer> updateCustomer(Customer customer);
	boolean deleteCustomer(int id);
}
