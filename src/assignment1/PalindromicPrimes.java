package assignment1;
//---------------Improve comment and do error handling-------



/**
 * Printing list of palindromic primes for the user-input n numbers.
 * 
 * Completion time: 1 hr
 * 
 * @author Kiran Gautam
 * @version 1.0
 */

import java.util.Scanner;

public class PalindromicPrimes {

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int initialPoint = 1;
		int initialPrime = 2;
		final int maxPerLine = 10;

		System.out.print("Please enter a number: ");
		int n = scan.nextInt();

		while (initialPoint <= n) {

			if (isPrime(initialPrime) && isPalindrom(initialPrime)) {
				System.out.print(initialPrime + " ");

				if (initialPoint % maxPerLine == 0) {
					System.out.println();
				}
				initialPoint++;
			}
			initialPrime++;
		}

	}

	private static boolean isPrime(int num) {

		if (num % 2 == 0 && num != 2) {
			return false;
		}
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	private static boolean isPalindrom(int num) {
		int originalNum = num;
		int reverseNum = 0;

		while (num > 0) {
			reverseNum = reverseNum * 10 + num % 10;
			num = num / 10;
		}

		return (originalNum == reverseNum);
	}
}