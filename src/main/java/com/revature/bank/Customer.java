package com.revature.bank;

public class Customer extends CheckingAccount {
	public Customer(String name, int customerId, double balance) {
		super(name,customerId, balance);
	}

	public static void main(String[] args) {
		CheckingAccount customer = new Customer("Jorge",10, 30000.00);
		CheckingAccount customer2 = new Customer("Travis",12, 15000.00);
		CheckingAccount customer3 = new Customer("Elena", 15, 200000.00);
		CheckingAccount customer4 = new Customer("Wilfred", 5, 10000.00);

		
		customer.depositFunds(150.00);
		customer.withdrawFunds(5000.00);
		System.out.println(customer.getBalance());
		customer.closeAccount();
	}


	
}
