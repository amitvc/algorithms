package com.algorithms.graph;

import java.sql.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Digraph {

	public List<Integer> vertexes[];
	public int vCount;

	public Digraph(int n) {
		vCount = n;
		vertexes = (List<Integer>[])new ArrayList[vCount];
		for(int i=0; i <vCount; i++) {
			vertexes[i] = new ArrayList<>();
		}
	}
	
	public void addEdge(int s, int d) {
		if(vertexes[s] == null) {
			vertexes[s] = new ArrayList<>();
		}
		vertexes[s].add(d);
	}
	
	public static int connectedComponents(Digraph g) {
		int count = 0;
		boolean visited[] = new boolean[g.vCount];
		Arrays.fill(visited, false);
		
		for(int i=0; i < g.vCount; i++) {
			if(!visited[i]) {
				dfs(visited, g, i);
				count++;
			}
		}
		return count;
	}
	
	public static void dfs(boolean visited[], Digraph g, int index) {
		visited[index] = true;
		for(Integer neighbor : g.vertexes[index]) {
			if(!visited[neighbor]) {
				dfs(visited, g, neighbor);
			}
		}
	}
	
	
	
	public void printTopologicalSort(Digraph g) {
		boolean visited[] = new boolean[g.vCount];
		Arrays.fill(visited, false);
		Stack<Integer> stack = new Stack();
		for(int i=0; i < g.vCount; i++) {
			if(!visited[i]) {
				dfs_topologic(g, i, visited, stack);
			}
		}
		
		while (stack.empty()==false)
            System.out.print(stack.pop() + " ");	
	}
	
	private void dfs_topologic(Digraph g, int index, boolean[] visited, Stack<Integer> stack) {
		visited[index] = true;
		for(Integer neighbor: g.vertexes[index]) {
			if(!visited[neighbor]) {
				dfs_topologic(g, neighbor, visited, stack);
			}
		}
		stack.push(index);
	}

	public static void main(String[] args) {
		Digraph dg = new Digraph(8);
		dg.addEdge(0, 1);
		dg.addEdge(1, 2);
		dg.addEdge(2, 3);
		dg.addEdge(3, 4);
		dg.addEdge(4, 5);
		dg.addEdge(5, 6);
		dg.addEdge(7, 7);
		int count = dg.connectedComponents(dg);
		System.out.println("CC : "+count);
		dg = new Digraph(6);
		dg.addEdge(5, 2);
        dg.addEdge(5, 0);
        dg.addEdge(4, 0);
        dg.addEdge(4, 1);
        dg.addEdge(2, 3);
        dg.addEdge(3, 1);
        dg.printTopologicalSort(dg);
        
	}

}
