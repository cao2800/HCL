package com.assignment2;

import java.util.Scanner;

public class PrimeNumbers {
	static void primeNumbers(int[] nums) {
		for(int i = 0; i <nums.length; i++) {
			if(nums[i] == 0 || nums[i] == 1) {
				System.out.println(nums[i] + " is not a prime number");
			} else if(nums[i] % 2 == 1) {
				System.out.println(nums[i] + " is a prime number");
			} else {
				System.out.println(nums[i] + " is not a prime number");
			}
		}
	}
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the length of numbers array");
		int len = scnr.nextInt();
		int[] nums = new int[len];
		System.out.println("Enter numbers into array");
		
		for(int i = 0; i < len; i++) {
			nums[i] = scnr.nextInt();
		}
		primeNumbers(nums);
		scnr.close();
		
	}
	

}
