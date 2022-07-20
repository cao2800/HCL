package com.assignment2;

import java.util.Scanner;

public class Fibonacci {
	
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter the length of numbers array");
		int len = scnr.nextInt();
		
		int[] nums = new int[len];
		nums[0] = 0;
		nums[1] = 1;
		
		for (int i = 2; i < len; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		
		System.out.println("Fibonacci Series: ");
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i] + " ");
		}
		scnr.close();
	}

}
