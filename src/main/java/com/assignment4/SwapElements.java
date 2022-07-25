package com.assignment4;

import java.util.ArrayList;
import java.util.Collections;

public class SwapElements {
	public static void main(String[] args) {
	ArrayList<Integer> aList = new ArrayList<>();
	
	for(int i= 0; i <= 10; i++) {
		aList.add(i);
	}
	
	System.out.println("Array List before element swap " + aList);
	Collections.swap(aList, 0, 7);
	Collections.swap(aList, 1, 6);
	Collections.swap(aList, 2, 5);
	System.out.println("Array List after element swap  " + aList);
	}
}
