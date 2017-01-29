package assignment3;

public class Savings extends Account {

	public Savings() {
		super();
	}

	public Savings(int accountId, double balance, double annualInterestRate) {
		super(accountId, balance, annualInterestRate);
	}

	//Validation to ignore the transaction if withdraw more than balance
	public void withdraw(double withdrawAmount) {
		double balance = getBalance();
		double remainingBalance = balance - withdrawAmount;
		if (!(remainingBalance < 0.00)) {
			setBalance(remainingBalance);
		}
	}
}
