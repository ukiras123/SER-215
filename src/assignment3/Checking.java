package assignment3;

public class Checking extends Account {

	private final double overDraftLimit = -5000.00;

	public Checking() {
		super();
	}

	public Checking(int accountId, double balance, double annualInterestRate) {
		super(accountId, balance, annualInterestRate);
	}

	//Validation to ignore the transaction if withdraw more than overDraftLimit
	public void withdraw(double withdrawAmount) {
		double balance = getBalance();
		double remainingBalance = balance - withdrawAmount;
		if (!(remainingBalance < overDraftLimit)) {
			setBalance(remainingBalance);
		}
	}
}
