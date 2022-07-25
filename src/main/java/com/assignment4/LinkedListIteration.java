package com.assignment4;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListIteration {
	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		for(int i = 1; i <= 10; i++) {
			nums.add(i);
		}

		Iterator index = nums.listIterator(5);

		while(index.hasNext()) {
			System.out.print(index.next() + " ");
		}
	}

}
