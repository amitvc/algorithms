package com.algorithms.queues;

import java.util.Iterator;

public class MaxPQ<Key> {

	
	
	public static void main(String[] args) {
		MaxPQ<Integer> t = new MaxPQ<>();
		MaxPQ<String> s = new MaxPQ<>();
		String[] a = new String[1];

	    // b is an array of Object
	    Object[] b = a;

	    // Assign an Integer to b. This would be possible if b really were
	    // an array of Object, but since it really is an array of String,
	    // we will get a java.lang.ArrayStoreException.
	    b[0] = 1;
	}
	
	
}
