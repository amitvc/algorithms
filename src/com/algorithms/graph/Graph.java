package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class represents a basic undirected graph as adjency list.
 * 
 * @author amit
 *
 */
public class Graph {
	private int vertexCount;
	private int edgeCount;
	private List<Integer> nodes[];

	public Graph(int v) {
		vertexCount = v;
		nodes = (List<Integer>[]) new ArrayList[vertexCount];
		for (int i = 0; i < v; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
	}

	public void validate(int v) {
		if(v < 0 || v >= vertexCount)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertexCount - 1));
	}

	public void addEdge(int source, int destination) {
		validate(source);
		validate(destination);
		nodes[source].add(destination);
		nodes[destination].add(source);
		edgeCount++;
	}

	public static void main(String args[]) {
		
	}
}