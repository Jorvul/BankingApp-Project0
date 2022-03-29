package com.revature.bank;

public class Customer extends BankingAccounts {
	public Customer(int customerId, String name, double balance, String accountName, String accountType2) {
		super(customerId, name, balance, accountName, accountType2);
	}
	
	public Customer() {
		super();
	}

	public static void main(String[] args) {
		Customer customer = new Customer(10, "Jorge Palacios", 30000.00, "checkingAccount", "Savings Account");
		Customer customer2 = new Customer(12, "Travis Shaw", 15000.00, "checkingAccount", "Savings Account");
		Customer customer3 = new Customer(15,"Elena Wilde", 200000.00, "checkingAccount", "Savings Account");
		Customer customer4 = new Customer(5,"Wilfred Scott", 10000.00, "checkingAccount", "Savings Account");

		
		customer.depositFunds(150.00);
		customer.withdrawFunds(10000.00);
		System.out.println(customer.getBalance());
		customer.closeAccount();
	}


	
}
