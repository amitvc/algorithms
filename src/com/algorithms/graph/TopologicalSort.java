package com.algorithms.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class TopologicalSort {
	
	Graph g;
	public TopologicalSort(Graph g) {
		this.g= g;
	}

	
	public void postOrderTopologicalSort() {
		boolean visited[] = new boolean[g.vertexCount];
		Queue<Integer> q  = new LinkedList<>();
		for(int i=0; i < g.vertexCount; i++) {
			if(!visited[i]) {
				dfs(i, visited,q);
			}
		}
		System.out.println("\n"+q.toString());
	}
	
	
	public void dfs(int v, boolean visited[], Queue<Integer> q) {
		visited[v] = true;
		for(int neighbor : g.adj(v)) {
			if(!visited[neighbor]) {
				dfs(neighbor, visited,q);
			}
		}
		q.offer(v);
	}
	
	
	// prints a Topological Sort of the complete graph
	public void kahnTopologicalSort() {
		// Create a array to store indegrees of all
		// vertices. Initialize all indegrees as 0.
		int indegree[] = new int[g.vertexCount];

		// Traverse adjacency lists to fill indegrees of
		// vertices. This step takes O(V+E) time
		for (int i = 0; i < g.vertexCount; i++) {
			ArrayList<Integer> temp = (ArrayList<Integer>) g.nodes[i];
			for (int node : temp) {
				indegree[node]++;
			}
		}

		// Create a queue and enqueue all vertices with
		// indegree 0
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < g.vertexCount; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}

		// Initialize count of visited vertices
		int cnt = 0;

		// Create a vector to store result (A topological
		// ordering of the vertices)
		Vector<Integer> topOrder = new Vector<Integer>();
		while (!q.isEmpty()) {
			// Extract front of queue (or perform dequeue)
			// and add it to topological order
			int u = q.poll();
			topOrder.add(u);

			// Iterate through all its neighbouring nodes
			// of dequeued node u and decrease their in-degree
			// by 1
			for (int node : g.nodes[u]) {
				// If in-degree becomes zero, add it to queue
				if (--indegree[node] == 0)
					q.add(node);
			}
			cnt++;
		}

		// Check if there was a cycle
		if (cnt != g.vertexCount) {
			System.out.println("There exists a cycle in the graph");
			return;
		}

		// Print topological order
		for (int i : topOrder) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a graph given in the above diagram
        Graph g=new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        System.out.println("Following is a Topological Sort");
        TopologicalSort k = new TopologicalSort(g);
        k.kahnTopologicalSort();
        k.postOrderTopologicalSort();
        
	}

}
