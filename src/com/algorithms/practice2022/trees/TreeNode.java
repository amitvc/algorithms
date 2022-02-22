package com.algorithms.practice2022.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TreeNode {
    private final int value;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    private List<TreeNode> neighbors;
    public TreeNode(int value) {
        this.value = value;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(TreeNode n) {
        neighbors.add(n);
    }

    public List<TreeNode> getNeighbors() {
        return this.neighbors;
    }

    public int getValue() {
        return this.value;
    }



    public boolean isLeafNode() {
        return neighbors.isEmpty();
    }
}
