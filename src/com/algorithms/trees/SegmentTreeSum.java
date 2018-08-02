package com.algorithms.trees;

import java.util.Arrays;

public class SegmentTreeSum {
	
	public static void buildTree(int arr[], int sum_array[], int start, int end, int index) {
		if(start == end) {
			sum_array[index] = arr[start];
			return;
		}
		
		int mid = (start+end)/2;
		buildTree(arr, sum_array, start, mid, 2*index);
		buildTree(arr, sum_array, mid+1, end, 2*index+1);
		sum_array[index] = sum_array[2*index] + sum_array[2*index+1];
	
	}
	
	public static void main(String args[]) {
		int arr[] = {1,2,3,4,5,6};
		int sum_array[] = new int[arr.length*2+5];
		buildTree(arr, sum_array, 0, 5, 1);
	//	Arrays.stream(sum_array).forEach(System.out::println);
		int b = 7;
		int c = b & ~(1 << 0);
		System.out.println( 1 << 2);
	}

}
