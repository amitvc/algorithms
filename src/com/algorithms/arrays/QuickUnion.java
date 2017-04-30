package com.algorithms.arrays;

public class QuickUnion implements Connectivity {

	
	private int[] nodes;
	private final int NUMBER_OF_NODES;
	
	public QuickUnion(int N) {
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
		int sourceVal = rootOf(source);
		int destVal = rootOf(destination);
		nodes[sourceVal] =  nodes[destVal];
	}

	
	private int rootOf(int item) {
		while(item != nodes[item]) {
			item = nodes[item];
		}
		return item;
	}
	
	
	
	@Override
	public boolean connected(int source, int destination) {
		return false;
	}

	@Override
	public int find(int value) {
		return 0;
	}

}
