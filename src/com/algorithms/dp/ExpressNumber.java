package com.algorithms.dp;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ExpressNumber {
	public static int counter = 0;
	public static int count(int n) {
		counter++;
		if(n == 0) {
			return 1;
		} else if(n < 0) {
			return 0;
		}
		return count(n-1) + count(n-3) + count(n-5);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int c = count(40);
		System.out.println(c);
		System.out.println(counter);
		
		int arr[] = new int[100000000];
		for(int i=0 ; i < arr.length; i++) {
			arr[i] = ThreadLocalRandom.current().nextInt();
		}
		
		long start = System.currentTimeMillis();
		Arrays.sort(arr);
		long end  = System.currentTimeMillis();
		System.out.println("Time take to sort " + (end - start));
	}

}
