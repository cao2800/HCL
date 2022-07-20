package com.assignment2;

import java.util.Scanner;

public class ReverseWord {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Enter a word to be reversed");
		String reverseWord = scnr.next();
		
		String wordReversed = "";
		char ch;
		
		System.out.println("Word to be reversed " + reverseWord);
		
		for(int i = 0; i < reverseWord.length(); i++) {
			ch = reverseWord.charAt(i);
			wordReversed = ch+wordReversed;
		}
		
		System.out.println("Word after it is reversed " + wordReversed);
		scnr.close();
	}
}
