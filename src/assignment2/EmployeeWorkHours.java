package assignment2;

import java.util.Scanner;

public class EmployeeWorkHours {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Please enter the total no. of employees : ");
		int totalEmployee; 
		//Only positive integer allowed
		do {
			totalEmployee = Integer.parseInt(scan.nextLine());
			if (!(totalEmployee>0)) {
				System.out.print("Please enter the total no. of employees (positive non zero integer) : ");
			}
		} while (!(totalEmployee>0));
		
		System.out.print("Please enter the no. of working days in a week : ");
		int totalWorkDays;
		//Only 1-7 allowed
		do {
			totalWorkDays = Integer.parseInt(scan.nextLine());
			if (!(totalWorkDays>=1 && totalWorkDays<=7)) {
				System.out.print("Please enter the no. of working days in a week (1 - 7) : ");
			}
		} while (!(totalWorkDays>=1 && totalWorkDays<=7));
		
		String[] empName = new String[totalEmployee];
		String[] empHrDetail = new String[totalEmployee];
		for (int i = 0; i < totalEmployee; i++) {
			
			System.out.print("Please enter the name of employee[" + (i + 1) + "] : ");
			empName[i] = scan.nextLine();
			
			System.out.print("Pelase enter the no. of daily hours worked for " + empName[i] + " : ");
			empHrDetail[i] = scan.nextLine(); // Assumption is that hours will be an integer.
		}

		// Splitting and setting hours from string to an int array
		int[][] hours = new int[totalEmployee][totalWorkDays];
		for (int i = 0; i < totalEmployee; i++) {
			String[] splitted = empHrDetail[i].split("\\s+");
			for (int k = 0; k < totalWorkDays; k++) {
				hours[i][k] = Integer.parseInt(splitted[k]);
			}
		}

		// Adding total hours for each employee and creating array of sum of hours.
		int[] totalHours = new int[hours.length];
		for (int i = 0; i < hours.length; i++) {
			totalHours[i] = getTotalHours(hours, i);
		}

		// Sorting the hours and printing empName and hours in descending order
		sortPrintEmployee(totalHours, empName);
		scan.close();
	}

	public static void sortPrintEmployee(int[] sumArray, String[] name) {
		int temp1;
		String temp2;
		// Bubble shorting in descending
		for (int i = 0; i < sumArray.length - 1; i++) {
			for (int j = 0; j < sumArray.length - i - 1; j++) {
				if (sumArray[j] < sumArray[j + 1]) {
					temp1 = sumArray[j];
					sumArray[j] = sumArray[j + 1];
					sumArray[j + 1] = temp1;
					temp2 = name[j];
					name[j] = name[j + 1];
					name[j + 1] = temp2;
				}
			}
		}
		for (int i = 0; i < name.length; i++) {
			System.out.println(name[i] + " worked " + sumArray[i] + " hours");
		}

	}

	public static int getTotalHours(int[][] time, int rowIndex) {
		int total = 0;
		for (int column = 0; column < time[rowIndex].length; column++) {
			total += time[rowIndex][column];
		}
		return total;
	}
}
