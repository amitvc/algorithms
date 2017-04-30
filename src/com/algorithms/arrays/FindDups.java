package com.algorithms.arrays;

import java.util.Arrays;

public class FindDups {
	
	public static int dups(int[] array) {
		Arrays.sort(array);
		
		for(int i=0; i < array.length; i++) {
			if(i+1 < array.length && (array[i] ^ array[i+1]) == 0) {
				return array[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int arr[] = {19,29,33,18,192,29};
		System.out.println(dups(arr));
	}

}
