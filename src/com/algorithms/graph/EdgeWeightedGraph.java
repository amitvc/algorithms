package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
	
	public static class Edge {
		public final int weight,  v1,  v2;
		public Edge(int w, int v1, int v2) {
			this.weight = w;
			this.v1 = v1;
			this.v2 = v2;
		}
	}
	
	public List<Edge> [] vertices;
	public final int vCount;
	
	public EdgeWeightedGraph(int n) {
		this.vCount = n;
		vertices = (List<Edge>[])new ArrayList[vCount];
		for(int i=0; i < vCount; i++) {
			vertices[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(Edge e) {
		this.vertices[e.v1].add(e);
		this.vertices[e.v2].add(e);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
