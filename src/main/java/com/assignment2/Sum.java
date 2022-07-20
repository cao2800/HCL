package com.assignment2;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter 2 numbers and a predicted sum");
		
		System.out.println("Enter 1st number");
		int num1 = scnr.nextInt();
		
		System.out.println("Enter 2nd number");
		int num2 = scnr.nextInt();
		
		System.out.println("Enter predicted sum");
		int num3 = scnr.nextInt();
		
		if(num1 + num2 == num3) {
			System.out.println("True");
		} else {
			System.out.println("False");
		}
		scnr.close();
	}

}
