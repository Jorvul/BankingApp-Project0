package com.revature.bank;

public abstract class BankingAccounts {
	private int customerId;
	private String name;
	private double balance;
	private String accountName;
	private String accountType2;
	
	
	public BankingAccounts(int customerId, String name, double balance, String accountName, String accountType2) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.balance = balance;
		this.accountName = accountName;
		this.accountType2 = accountType2;
	}
	
	
	public BankingAccounts() {
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

	public String getAccountType2() {
		return accountType2;
	}


	public void setAccountType2(String accountType2) {
		this.accountType2 = accountType2;
	}

	@Override
	public String toString() {
		return "BankingAccounts [customerId=" + customerId + ", name=" + name + ", balance=" + balance
				+ ", accountName=" + accountName + ", accountType2=" + accountType2 + "]";
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
