package com.revature.bank;

public class Customer extends CheckingAccount {
	public Customer(int customerId, String name, double balance) {
		super(customerId, name, balance);
	}
	
	public Customer() {
		super();
	}

	public static void main(String[] args) {
		Customer customer = new Customer(10, "Jorge", 30000.00);
		Customer customer2 = new Customer(12, "Travis", 15000.00);
		Customer customer3 = new Customer(15,"Elena", 200000.00);
		Customer customer4 = new Customer(5,"Wilfred", 10000.00);

		
		customer.depositFunds(150.00);
		customer.withdrawFunds(10000.00);
		System.out.println(customer.getBalance());
		customer.closeAccount();
	}


	
}
