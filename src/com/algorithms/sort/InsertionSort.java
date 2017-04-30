package com.algorithms.sort;

import java.util.Random;

import com.sun.media.sound.Toolkit;

public class InsertionSort {

	
	/**
	 * Insertion sort which sorts the array in ascending order.
	 * Best case time - O(n)
	 * Worst case time - O(n2)
	 * @param arr
	 */
	
	public static void sort(int arr[]) {
		
		for(int i=1; i < arr.length; i++) {
			int curr = i;
			int value = arr[i];
			while(curr > 0 && value < arr[curr-1]) {
				arr[curr] = arr[curr-1];
				curr--;
			}
			
			arr[curr] = value;
		}
		
	}
	
	public static void main(String[] args) {
		// TOO Auto-generated method stub
		int arr[] = {7,6,2,3,1,5,8};
		int[] largeArr = new int[1000000];
	//	
		Random rand = new Random();
		for(int i=0; i < largeArr.length; i++) {
			largeArr[i] = rand.nextInt(Integer.MAX_VALUE ) + 1;
		}
		
		long start = System.currentTimeMillis();
		sort(largeArr);
		System.out.println("Time taken to sort " + largeArr.length+ " takes "+(System.currentTimeMillis() - start) + " ms");
		java.awt.Toolkit.getDefaultToolkit().beep();
	}

}
