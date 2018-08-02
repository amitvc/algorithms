package com.algorithms.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents  
 *
 *
 */
public class DirectedGraph {
    
    public List<Integer> edges[];
    
    public DirectedGraph(int n) {
        edges = new ArrayList[n];
    }
    
    public void addEdge(int s, int d) {
       if(edges[s] == null) {
           edges[s] = new ArrayList<>();
       }
       edges[s].add(d);
    }
    
    public static void main(String[] args) {
        DirectedGraph dg = new DirectedGraph(4);
        dg.addEdge(0, 3);
        dg.addEdge(0, 2);
        dg.addEdge(0, 3);
        dg.addEdge(0, 2);
    }
}
