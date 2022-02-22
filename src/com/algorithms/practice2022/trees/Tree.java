package com.algorithms.practice2022.trees;

import java.util.List;

public interface Tree {

    List<TreeNode> getNodeNeighbors(int nodeId);
    void addNodes(int root, int...children);
    void markRoot(int root);
    boolean isEmpty();
    TreeNode getRoot();
}
