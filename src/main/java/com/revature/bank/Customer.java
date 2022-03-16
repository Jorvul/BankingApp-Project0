package com.revature.bank;

public class Customer extends CheckingAccount {
	public Customer(String name, double balance, int customerId) {
		super(name, balance, customerId);
	}

	public static void main(String[] args) {
		CheckingAccount customer = new Customer("Jorge", 30000.00, 100);
		CheckingAccount customer2 = new Customer("Travis", 15000.00, 101);
		CheckingAccount customer3 = new Customer("Elena", 200000.00, 102);
		CheckingAccount customer4 = new Customer("Wilfred", 10000.00, 103);

		
		customer.depositFunds(150.00);
		customer.withdrawFunds(5000.00);
		System.out.println(customer.getBalance());
		customer.closeAccount();
	}


	
}
