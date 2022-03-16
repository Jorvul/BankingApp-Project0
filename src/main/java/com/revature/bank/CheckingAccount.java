package com.revature.bank;

public abstract class CheckingAccount {
	private String name;
	private double balance;
	private int customerId;
	
	
	public CheckingAccount(String name, double balance, int customerId) {
		super();
		this.name = name;
		this.balance = balance;
		this.customerId = customerId;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public double depositFunds(double amount) {
		return this.balance = balance + amount;
	}
	
	public double withdrawFunds(double amount) {
		return this.balance = balance - amount;
	}
	
	public void closeAccount() {
		this.balance = 0;
		System.out.println("Your account is closed and the balance is " + this.balance);
	}
	
	

}
