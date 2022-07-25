package com.assignment4;

import java.util.LinkedList;

public class ReplaceElementInLinkedList {
	public static void main(String[] args) {
		LinkedList<Integer> nums = new LinkedList<>();
		for(int i = 1; i <= 10; i++) {
			nums.add(i);
		}

		System.out.println("Linked list before element is replaced " + nums);
		nums.set(5, 100);
		System.out.println("Linked list after element is replaced " + nums);
	}

}
