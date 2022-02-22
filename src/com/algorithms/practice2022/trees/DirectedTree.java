package com.algorithms.practice2022.trees;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Tree where edges have direction.
 */
public class DirectedTree implements Tree {

    private final Map<Integer, TreeNode> nodes;
    private TreeNode rootNode;

    public DirectedTree() {
        nodes = new HashMap<>();
    }

    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    @Override
    public TreeNode getRoot() {
        return this.rootNode;
    }

    @Override
    public List<TreeNode> getNodeNeighbors(int node) {
        if (nodes.containsKey(node)) {
            return nodes.get(node).getNeighbors();
        }
        throw new RuntimeException("Could not find node " + node + " in the tree");
    }

    @Override
    public void addNodes(int root, int...children) {
        if (!nodes.containsKey(root)) {
            TreeNode newNode = new TreeNode(root);
            nodes.put(root, newNode);
        }

        TreeNode rootNode = nodes.get(root);
        for (int child : children) {
            if (!nodes.containsKey(child)) {
                TreeNode newNode = new TreeNode(child);
                nodes.put(child, newNode);
            }
            TreeNode childNode = nodes.get(child);
            rootNode.addNeighbor(childNode);
        }
    }

    @Override
    public void markRoot(int root) {
        if (!nodes.containsKey(root)) {
            throw new IllegalArgumentException("Root node not available in the tree");
        }
        rootNode = nodes.get(root);
    }
}
