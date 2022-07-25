package com.assignment4;

import java.util.HashSet;

public class HashSetToArray {
	public static void main(String[] args) {
		HashSet<Integer> nums = new HashSet<>();
		for(int i = 1; i <= 10; i++) {
			nums.add(i);
		}
		
		System.out.println("HashSet before conversion to array " + nums);
		int[] nums2 = new int[nums.size()];
		
		int i = 0;
		for(int x : nums) {
			nums2[i++] = x;
		}
		
		System.out.print("HashSet after conversion to array ");
		for(int n : nums2) {
			System.out.print(n + " ");
		}
	}

}
