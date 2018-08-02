package com.algorithms.arrays;

import java.util.Arrays;

public class QuickSort {

	
	public static void qs(int arr[], int si, int ei) {
		if (ei <= si) return;
        int p = partition(arr, si, ei);
        qs(arr, si, p-1);
        qs(arr, p+1, ei);
	}
	
	 private static int partition(int[] a, int lo, int hi) {
	        int i = lo;
	        int j = hi + 1;
	        int pe = a[lo];
	        while (true) { 

	            while (a[++i] < pe) {
	                if (i == hi) break;
	            }

	            while (pe < a[--j]) {
	                if (j == lo) break;
	            }

	            // check if pointers cross
	            if (i >= j) break;

	            swap(a, i, j);
	        }

	        swap(a, lo, j);

	        return j;
	    }
	
	private static void swap(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		int temp = arr[low];
		arr[low] = arr[high];
		arr[high] = temp;
		
	}
	
	// pe = 8
	//8,3,4,6,1,90,2
	 public static void quickSort(int arr[]) {
	        qs(arr, 0, arr.length);
	   
	 }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {2,6,8,5,4,3};
		qs(arr,0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);

	}

}
