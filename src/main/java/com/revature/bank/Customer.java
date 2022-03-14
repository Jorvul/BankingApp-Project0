package com.revature.bank;

public class Customer extends CheckingAccount {
	public Customer(String name, double balance) {
		super(name, balance);
	}

	public static void main(String[] args) {
		CheckingAccount customer = new Customer("Jorge", 30000.00);
		
		customer.depositFunds(150.00);
		customer.withdrawFunds(5000.00);
		System.out.println(customer.getBalance());
	}


	
}
