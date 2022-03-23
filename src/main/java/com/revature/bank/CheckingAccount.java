package com.revature.bank;

public abstract class CheckingAccount {
	private int customerId;
	private String name;
	private double balance;
	private String accountName;
	
	
	public CheckingAccount(int customerId, String name, double balance, String accountName) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.balance = balance;
		this.accountName = accountName;
	}
	
	
	public CheckingAccount() {
		super();
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
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
	
	public String getAccountName() {
		return accountName;
	}


	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "CheckingAccount [customerId=" + customerId + ", name=" + name + ", balance=" + balance
				+ ", accountName=" + accountName + "]";
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
