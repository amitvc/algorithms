package com.algorithms.basic;

public class NumberReverse {
	
	public static void main(String[] args) {
		int num =  3400936;
		// 643
		int result =0;
		while(num != 0) {
			int r = num % 10;
			num = num / 10;
			result = result *10 + r;
		}
		
		System.out.println(result);
	}

}
