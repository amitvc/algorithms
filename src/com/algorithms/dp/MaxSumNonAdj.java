package com.algorithms.dp;

public class MaxSumNonAdj {

	public static int maxSum(int[] arr, int i) {
		if(i == 0) {
			return arr[0];
		}
		
		if(i==1) {
			return Math.max(arr[0], arr[1]);
		}
		
		return Math.max(maxSum(arr, i-1), arr[i] + maxSum(arr, i-2));
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1, 12, 3, 9, 2,21};
		int a = maxSum(arr, arr.length-1);
		System.out.println(a);
	}

}
