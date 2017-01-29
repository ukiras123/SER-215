package assignment3;

import java.util.Date;

public class Account {
	private int accountId = 0;
	private double balance = 0;
	private double annualInterestRate = 0;
	private Date dateCreated;

	public Account() {
		this(0, 0, 0);  //Default account
	}
	
	public Account(int accountId, double balance, double annualInterestRate) {
		this.accountId = accountId;
		this.balance = balance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = new Date();
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public double getMonthlyInterest() {
		double monthlyInterest = (balance * (annualInterestRate / 100) / 12);  //Getting monthly interest amount
		return monthlyInterest;
	}

	public void withdraw(double withdrawAmount) {
		balance = balance - withdrawAmount;
	}

	public void deposit(int amount) {
		balance = balance + amount;
	}

	public void deposit(double amount) {
		balance = balance + amount;
	}

}
