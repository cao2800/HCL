package com.assignment4;

import java.util.ArrayList;
import java.util.Collections;

public class ReverseElements {
	public static void main(String[] args) {
	ArrayList<Integer> aList = new ArrayList<>();
	
	aList.add(1);
	aList.add(2);
	aList.add(3);
	aList.add(4);
	aList.add(5);
	
	System.out.println("Array List before reversal " + aList);
	Collections.reverse(aList);
	System.out.println("Array List after reversal " + aList);
	}
}
