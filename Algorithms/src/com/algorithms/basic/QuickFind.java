package com.algorithms.basic;

public class QuickFind {

	int elements[];
	
	/**
	 * initialize the array and also elements.
	 * Initially all elements will be initialized to the their own
	 * index value.
	 * @param SIZE
	 */
	public QuickFind(int SIZE) {
		elements = new int[SIZE];
		for(int i=0; i<SIZE; i++) {
			elements[i] = i;
		}
	}
	
	/**
	 * Entry point to the program
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
