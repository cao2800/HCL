package com.assignment3;

public class WashingMachine {
	
	public static void main(String[] args) {
		switchON();
		
		int numOfClothes = 50;
		acceptClothes(numOfClothes);
		
		acceptDetergent();
		
		switchOFF();
	}
	
	public static void switchON() {
		System.out.println("Swtich is ON");
	}
	
	public static int acceptClothes(int numOfClothes) {
		System.out.println("Number of Clothes is " + numOfClothes);
		return numOfClothes;
	}
	
	public static void acceptDetergent() {
		System.out.println("Detergent Accepted");
	}
	
	public static void switchOFF() {
		System.out.println("Switch is OFF");
	}
}
