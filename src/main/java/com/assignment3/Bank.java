package com.assignment3;

public class Bank {
	public static void main(String[] args) {
		deposit(5000, 50000);
		
		withdraw(400, 2000);
		
		withdraw(500, 400);
	}
	
	public static void deposit(int amount, int balance) {
		System.out.println("New Balance after deposit is " + (amount+balance));
		//return amount + balance;
	}
	
	public static void withdraw(int amount, int balance) {
		int newBalance = 0;
		
		if(balance >= amount) {
			newBalance = balance - amount;
			System.out.println("New Balance after withdrawal is " + newBalance);
		} else {
			System.out.println("$0 withdrawn");
			//return 0;
		}
		
		//return newBalance;
	}
}
