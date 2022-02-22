package com.algorithms.practice2022.graphs;

import java.util.Arrays;

public class TraversalTest {
    public static void main(String[] args) {
        Graph<Integer> graph = new UndirectedGraph<>();
        graph.addEdge(0, 1);
        graph.addEdge(0, 9);

        graph.addEdge(1, 8);

        graph.addEdge(9, 8);

        graph.addEdge(8, 7);

        graph.addEdge(7, 10);
        graph.addEdge(7, 11);
        graph.addEdge(7, 6);
        graph.addEdge(7, 3);

        graph.addEdge(11, 10);

        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(3, 2);

        graph.addEdge(5, 6);

        graph.addEdge(12, 12);

        DepthFirstSearch dfs = new DepthFirstSearch();
        dfs.dfs(graph);
        System.out.println(Arrays.toString(dfs.getEdgeFrom()));
    }
}
