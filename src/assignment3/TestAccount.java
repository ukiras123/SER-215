package assignment3;

import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestAccount {
	private static int savingAccountId;
	private static int checkingAccountId;
	private static double savingBalance;
	private static double savingInterestRate;
	private static double checkingBalance;
	private static double checkingInterestRate;
	private static double checkingWithdraw;
	private static double checkingDeposit;
	private static double savingWithdraw;
	private static double savingDeposit;
	private static Scanner scan = new Scanner(System.in);
	private static NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

	public static void main(String[] args) {
		getCheckingInfo(); // Getting required info from user to open checking account 
		getSavingInfo();  // Getting required information from user to open saving account
		
		Savings savingAccount = new Savings(savingAccountId, savingBalance, savingInterestRate);
		Checking checkingAccount = new Checking(checkingAccountId, checkingBalance,checkingInterestRate);
		
		checkingWithdraw = validDoubleUserInput("Please enter amount to withdraw from Checking account ($) : ");
		
		//Making sure user can not cross overdraft limit allowing user to withdraw $0
		do {
			checkingAccount.withdraw(checkingWithdraw);
			if (checkingWithdraw!=0 &&checkingAccount.getBalance() == checkingBalance) {
				checkingWithdraw = validDoubleUserInput("Please enter amount to withdraw from Checking account ($) : ");
			}
		} while (checkingWithdraw!=0 && checkingAccount.getBalance() == checkingBalance);
		
		checkingAccount.withdraw(checkingWithdraw);
		checkingDeposit = validDoubleUserInput("Please enter amount to deposit to Checking account ($) : ");
		
		System.out.println("");
		checkingAccount.deposit(checkingDeposit);
		savingWithdraw = validDoubleUserInput("Please enter amount to withdraw from Saving account ($) : ");
		
		//Making sure user can not withdraw more than saving's balance allowing user to withdraw $0
		do {
			savingAccount.withdraw(savingWithdraw);
			if (savingWithdraw!=0 && savingAccount.getBalance() == savingBalance) {
				savingWithdraw = validDoubleUserInput("Please enter amount to withdraw from Saving account ($) : ");
			}
		} while (savingWithdraw!=0 && savingAccount.getBalance() == savingBalance);
		
		savingAccount.withdraw(savingWithdraw);
		
		do{
		savingDeposit = validDoubleUserInput("Please enter amount to deposit to Saving account ($) : ");
		} while (savingDeposit < 0);
		savingAccount.deposit(savingDeposit);
		System.out.println("");
		
		//Printing the final info of saving and checking accounts
		System.out.println("Checking --> \n\tid : "
				+ checkingAccount.getAccountId() + "\n\tcurrent balance: "
				+ currencyFormatter.format(checkingAccount.getBalance()) + "\n\tmonthly interest: "
				+ currencyFormatter.format(checkingAccount.getMonthlyInterest())
				+ "\n\taccount creation date: "
				+ checkingAccount.getDateCreated());
		
		System.out.println("Saving --> \n\tid : "
				+ savingAccount.getAccountId() + "\n\tcurrent balance: "
				+ currencyFormatter.format(savingAccount.getBalance()) + "\n\tmonthly interest: "
				+ currencyFormatter.format(savingAccount.getMonthlyInterest())
				+ "\n\taccount creation date: "
				+ savingAccount.getDateCreated());
	}

	private static void getCheckingInfo() {
		//false parameter makes sure, user can input only positive integer
		checkingAccountId = validIntUserInput("Please enter Checking Account ID : ");
		checkingBalance = validDoubleUserInput("Please enter Checking account balance ($) : ");
		checkingInterestRate = validDoubleUserInput("Please enter Checking account annual interest rate (%) : ");
		System.out.println("");
	}
	
	private static void getSavingInfo() {
		//false parameter makes sure, user can input only positive integer
		savingAccountId = validIntUserInput("Please enter Saving Account ID : ");
		savingBalance = validDoubleUserInput("Please enter Saving account balance ($) :  ");
		savingInterestRate = validDoubleUserInput("Please enter Saving account annual interest rate (%) : ");
		System.out.println("");
	}
	
	//User input validation only positive double permitted
	private static double validDoubleUserInput(String userQuestion)
	{
		double userInputValue = 0;
		boolean error ;
		do {
			error	= false;
			try {
				System.out.print(userQuestion);
				userInputValue = scan.nextDouble();
			} catch (InputMismatchException exception) {
				scan.next();
				error = true;
			}
		} while (error == true || userInputValue < 0);
		
		return userInputValue;
	}
	
	//User input validation only positive integer permitted
	private static int validIntUserInput(String userQuestion)
	{
		int userInputValue = 0;
		boolean error;
		do {
			error = false;
			try {
				System.out.print(userQuestion);
				userInputValue = scan.nextInt();
			} catch (InputMismatchException exception) {
				scan.next();
				error = true;
			}
		} while (error == true || userInputValue<0);
		return userInputValue;
	}
}
