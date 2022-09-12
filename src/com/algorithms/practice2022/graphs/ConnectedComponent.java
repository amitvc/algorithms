package com.algorithms.practice2022.graphs;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectedComponent {


    public static int countCC(Graph g) {
        AtomicInteger cc = new AtomicInteger(0);
        Set<Integer> vertexes = g.getAllNodes();
        boolean visited[] = new boolean[vertexes.size()];
        for (Integer v : vertexes) {
            if (!visited[v]) { // not visited
                dfs(v, g, visited);
                cc.incrementAndGet();
            }
        }
        System.out.println("The connected components of this graph is "+ cc.get());
        return cc.get();
    }

    private static void dfs(int v, Graph g, boolean visited[]) {
        visited[v] = true;
        List<Integer> neighbors = g.neighbors(v);
        for (Integer neighbor:  neighbors) {
            if (!visited[neighbor]) {
                dfs(neighbor, g, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph<Integer> g  = new UndirectedGraph();
        g.addEdge(0,1);
        g.addEdge(0,5);
        g.addEdge(0,2);

        g.addEdge(2,3);
        g.addEdge(2,4);

        g.addEdge(3,4);
        g.addEdge(3,5);

        g.addEdge(6,7);
        g.addEdge(7,8);

        g.addEdge(9, 10);
        g.addEdge(9,11);
        g.addEdge(9,12);

        g.addEdge(10,12);
        g.addEdge(11,12);

        countCC(g);


    }
}
