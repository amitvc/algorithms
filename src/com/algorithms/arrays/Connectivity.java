package com.algorithms.arrays;

public interface Connectivity {
	
	public void union(int source, int destination);
	
	public boolean connected(int source, int destination);
	
	public int find(int value);

}
