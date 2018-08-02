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
	List<Integer> nodes[];
	
	public int vertexCount;
	public int edgeCount;
	private boolean marked[];
	
	public Graph(int vCount) {
		this.vertexCount = vCount;
		nodes = (List<Integer>[])new ArrayList[vCount];
		marked = new boolean[vCount];
		for(int i=0; i < vCount; i++) {
			nodes[i] = new ArrayList<Integer>();
		}
	}
	
	public void addEdge(int source, int destination) {
		nodes[source].add(destination);
		//nodes[destination].add(source);
		edgeCount++;
	}
	
	public Iterable<Integer> adj(int index) {
		return nodes[index];
	}
	
	public void test() {
		int count = 0;
		 for (int i=0; i< vertexCount;i++) {
	            if (!marked[i]) {
	                dfs(this, i);
	                count++;
	            }
	        }
		 
		 System.out.println(count);

	}
	
	 // DFS on graph G
    private void dfs(Graph G, int v) { 
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }
	
	public static void main(String args[]) {
		Graph g = new Graph(8);
		g.addEdge(0, 1);
		g.addEdge(0, 5);
		
		g.addEdge(5,4);
		g.addEdge(4, 3);
		g.addEdge(3, 2);
		g.addEdge(2, 0);
		g.addEdge(6, 7);
		g.test();
		
	}
}