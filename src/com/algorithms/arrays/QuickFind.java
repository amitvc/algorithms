package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * 
 * @author amit
 *
 */
public class QuickFind implements Connectivity {

	
	private int[] nodes;
	private final int NUMBER_OF_NODES;
	
	public QuickFind(int N) {
		nodes = new int[N];
		NUMBER_OF_NODES = N;
		init();
	}
	
	private void init() {
		for(int i=0; i < NUMBER_OF_NODES; i++) {
			nodes[i] = i;
		}
	}

	@Override
	public void union(int source, int destination) {
		assert(source < NUMBER_OF_NODES);
		assert(destination < NUMBER_OF_NODES);
		
		int sourceValue = nodes[source];
		
		if(nodes[source] == nodes[destination]) return;
		
		for(int i=0; i < NUMBER_OF_NODES; i++) {
			if(nodes[i] == sourceValue) {
				nodes[i] = nodes[destination];
			}
		}
	}

	@Override
	public boolean connected(int source, int destination) {
		return nodes[source] == nodes[destination];
	}

	@Override
	public int find(int value) {
		return 0;
	}
	
	public String toString() {
		return new ArrayList<>(Arrays.asList(nodes)).toString();
	}
	
	public static void main(String[] args) {
		Connectivity c = new QuickFind(10);
		c.union(5, 0);
		c.union(7,2);
		c.union(1,6);
		c.union(6,2);
		c.union(5,7);
		c.union(7,0);
		
		
		System.out.println(c.connected(1,7));
	}

}
