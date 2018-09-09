package com.algorithms.arrays;


public class TestGeneric {

	public static long collapse(long num) {
		if(num < 10) return num;
		long sum = 0;
		while(num > 10) {
			sum += num %10;
			num = num / 10;
		}
		sum += num;
		return collapse(sum);
	}
	
	public static void main(String[] args) {
		System.out.println(collapse(489));
	}
}
