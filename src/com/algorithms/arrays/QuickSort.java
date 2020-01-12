package com.algorithms.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.concurrent.ThreadLocalRandom;

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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = new int[500000000];
//		for(int i=0; i < arr.length; i++) {
//			arr[i] = ThreadLocalRandom.current().nextInt(0,500000000);
//		}
		long st = System.currentTimeMillis();
		System.out.println("Starting ");
		int arr1[] = {5,4,8,9,2,81,3};
		qs(arr1, 0, arr1.length-1);
		System.out.println("Ended " + (System.currentTimeMillis() - st) / 1000);

	}

}
