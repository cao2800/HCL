package com.assignment2;

public class SwapVariables {
	
	public static void main(String[] args) {
		int num1 = 2;
		int num2 = 4;
		
		int tempNum = 0;
		
		System.out.println("Pre Swap num1 is " + num1 + " num2 is " + num2);
		
		tempNum = num1;
		num1 = num2;
		num2 = tempNum;
		
		System.out.println("Post swap num1 is " + num1 + " num2 is " + num2);
	}

}
