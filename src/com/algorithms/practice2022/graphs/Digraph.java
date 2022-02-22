package com.algorithms.practice2022.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Digraph<T> implements Graph<T>{

    private Map<T, List<T>> vertexes;

    public Digraph() {
        vertexes = new HashMap<>();
    }

    @Override
    public void addEdge(T src, T dst) {
        if (!vertexes.containsKey(src)) {
            List<T> neighbors = new ArrayList<>();
            vertexes.put(src, neighbors);
        }
        List<T> neighbors = vertexes.get(src);
        neighbors.add(dst);
        if (!vertexes.containsKey(dst)) {
            vertexes.put(dst, new ArrayList<>());
        }
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
