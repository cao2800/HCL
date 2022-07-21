package com.assignment3;

public class Student {
	public static void main(String[] args) {
		
		studentAverage(45, 84, 65);
		
		studentInput("Claudio Ordaz");
	}
	
	public static void studentAverage(int exam1, int exam2, int exam3) {
		if(((exam1 + exam2 + exam3) / 3) < 50 ) {
			System.out.println("Student has failed");
		} else {
			System.out.println("Student has passed");
		}
		
	}
	
	public static String studentInput(String studentName) {
		
		System.out.println(studentName);
		return studentName;
	}
}
