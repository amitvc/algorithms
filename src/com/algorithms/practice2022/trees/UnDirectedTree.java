package com.algorithms.practice2022.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Tree where the edge is undirected.
 * E.g If there is an edge between A and B then there is an edge between B and A as well.
 */
public class UnDirectedTree implements Tree {

    private Map<Integer, TreeNode> nodes;

    public UnDirectedTree() {
        this.nodes = new HashMap<>();
    }


    @Override
    public List<TreeNode> getNodeNeighbors(int nodeId) {
        return null;
    }

    @Override
    public void addNodes(int root, int... children) {
        if (!nodes.containsKey(root)) {
            TreeNode node = new TreeNode(root);
            nodes.put(root, node);
        }
        TreeNode rootNode = nodes.get(root);
        List<TreeNode> childNodes = getTreeNodesById(children);

        childNodes.stream().forEach(n -> {
            rootNode.addNeighbor(n);
            n.addNeighbor(rootNode);
        });
    }

    private List<TreeNode> getTreeNodesById(int...nodeIds) {
        List<TreeNode> nodeList = new ArrayList<>();
        for (int id : nodeIds) {
            if (!nodes.containsKey(id)) {
                TreeNode node = new TreeNode(id);
                nodes.put(id, node);
            }
            TreeNode node = nodes.get(id);
            nodeList.add(node);
        }
        return nodeList;
    }

    @Override
    public void markRoot(int root) {

    }

    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    @Override
    public TreeNode getRoot() {
        return null;
    }
}
