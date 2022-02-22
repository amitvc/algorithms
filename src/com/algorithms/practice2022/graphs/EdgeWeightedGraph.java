package com.algorithms.practice2022.graphs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class EdgeWeightedGraph<T extends Comparable<T>> implements Graph<T> {

    private Map<Integer, List<T>> vertexes;

    public EdgeWeightedGraph() {
        vertexes = new HashMap<>();
    }

    @Override
    public void addEdge(T src, T dst) {

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
        return vertexes.values().stream().flatMap(List::stream).collect(Collectors.toSet());
    }
}
