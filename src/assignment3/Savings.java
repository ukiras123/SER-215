package assignment3;

public class Savings extends Account {

	public Savings() {
		super();
	}

	public Savings(int accountId, double balance, double annualInterestRate) {
		super(accountId, balance, annualInterestRate);
	}

	//Validation to stop transaction if withdraw more than balance
	public void withdraw(double withdrawAmount) {
		double balance = getBalance();
		double remainingBalance = balance - withdrawAmount;
		if (!(remainingBalance < 0.00)) {
			setBalance(remainingBalance);
		}
	}
}
