package com.algorithms.practice2022.graphs;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {

    public int[] getEdgeFrom() {
        return edgeFrom;
    }

    private int edgeFrom[];

    public void dfs(Graph g) {
        boolean visited[] = new boolean[g.size()];
        edgeFrom = new int[g.size()];
        Arrays.fill(visited, false);

        Set<Integer> vertexes = g.getAllNodes();
        System.out.println("Starting dfs for graph");
        for (Integer n : vertexes) {
            dfs(n, g, visited, edgeFrom);
        }
    }

    private void dfs(Integer n, Graph g, boolean[] visited, int[] edgeFrom) {
        if (!visited[n.intValue()]) {
            visited[n.intValue()] = true;
            System.out.println("" + n);

            List<Integer> neighbors = g.neighbors(n);
            for (Integer neighbor : neighbors) {
                edgeFrom[neighbor] = n;
                dfs(neighbor, g, visited, edgeFrom);
            }
        }
    }


}
