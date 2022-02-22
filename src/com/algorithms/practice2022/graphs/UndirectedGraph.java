package com.algorithms.practice2022.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;


public class UndirectedGraph<T> implements Graph<T>{


    private Map<T, List<T>> vertexes;

    public UndirectedGraph() {
        vertexes = new HashMap<>();
    }

    @Override
    public void addEdge(T src, T dst) {
       getNeighbors(src).add(dst);
       getNeighbors(dst).add(src);
    }

    private List<T> getNeighbors(T node) {
        if(!vertexes.containsKey(node)) {
            List<T> neighbors = new ArrayList<>();
            vertexes.put(node, neighbors);
        }
        return vertexes.get(node);
    }

    @Override
    public List<T> neighbors(T node) {
        return vertexes.get(node);
    }

    @Override
    public int size() {
        return vertexes.size();
    }

    @Override
    public Set<T> getAllNodes() {
        return vertexes.keySet();
    }
}