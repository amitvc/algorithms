package com.algorithms.basic;

import java.util.Arrays;

public class ArraySumRecursive {

	
	public static int sum(int a[]) {
		
		if(a.length >0) {
			return a[0] + sum(Arrays.copyOfRange(a, 1, a.length));
		} else {
			return 0;
		}
	}
	
	public static void main(String[] args) {
		int a[] = {8};
		int val = sum(a);
		System.out.println(val);
	}

}
