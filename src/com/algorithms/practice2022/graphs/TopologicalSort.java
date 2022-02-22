package com.algorithms.practice2022.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class TopologicalSort {


    public TopologicalSort() {
    }

    public void printTopologicalOrder(Graph g) {
        assert  g.size() != 0;
        boolean visited[] = new boolean[g.size()];
        Arrays.fill(visited, false);

        Set<Integer> vertexes =  g.getAllNodes();
        for (Integer node: vertexes) {
            if (!visited[node]) {
                dfs(g, node, visited);
            }
        }
    }

    private static void dfs(Graph g, Integer node, boolean[] visited) {
        visited[node] = true;
        List<Integer> neighbors = g.neighbors(node);
        for (Integer neighbor: neighbors) {
            if (!visited[neighbor]) {
                dfs(g, neighbor, visited);
            }
        }
        System.out.print(node + ", ");
    }

    public static void main(String[] args) {
        Graph g = new Digraph();
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);

        g.addEdge(1, 4);



        g.addEdge(3, 2);
        g.addEdge(3,5);
        g.addEdge(3,4);
        g.addEdge(3,6);

        g.addEdge(5,2);

        g.addEdge(6,0);
        g.addEdge(6,4);
        TopologicalSort tp = new TopologicalSort();
        tp.printTopologicalOrder(g);
    }
}
