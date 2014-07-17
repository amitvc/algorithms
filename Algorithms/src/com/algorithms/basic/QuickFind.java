package com.algorithms.basic;

/**
 * QuickFind implementation of algorithm using array.
 * the connected operation runs in constant time.
 * The union operation runs in N time 
 * @author amitvc
 *
 */
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
	 * Identifies if two elements are connected.
	 * @param p
	 * @param q
	 * @return true if there is connection between elements
	 */
	public boolean connected(int p, int q) {
		return elements[p] == elements[q];
	}
	
	/**
	 * connects two elements
	 * @param p
	 * @param q
	 */
	public void union(int p, int q) {
		int oldValue = elements[p];
		for(int i=0; i < elements.length; i++) {
			if(elements[i] == oldValue) {
				elements[i] = elements[q];
			}
		}
	}
	
	/**
	 * Entry point to the program
	 * @param args
	 */
	public static void main(String[] args) {
		QuickFind qF = new QuickFind(6);
		qF.union(2, 3);
		qF.union(2, 5);
		System.out.println(""+qF.connected(2, 3));
		System.out.println(""+qF.connected(5, 3));
	}
}
