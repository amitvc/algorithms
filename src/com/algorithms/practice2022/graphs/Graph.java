package com.algorithms.practice2022.graphs;

import java.util.*;

public interface Graph<T> {
    void addEdge(T src, T dst);
    List<T> neighbors(T node);
    int size();
    Set<T> getAllNodes();
}
