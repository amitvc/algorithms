package com.algorithms.practice2022.trees;

public class LeafNodeSumProblem {

    static class Result {
        private int currentTotal;
        public Result() {}

        public void increment(int value) {
            currentTotal += value;
        }
    }
    public static int calculateLeafSum(Tree t) {
        if (t.isEmpty()) {
            throw new IllegalArgumentException("Provided tree is empty");
        }

        Result result = new Result();
        dfs(result, t.getRoot());
        return result.currentTotal;
    }

    private static void dfs(Result result, TreeNode root) {
        if (root.isLeafNode()) {
            result.increment(root.getValue());
        }

        for (TreeNode neighbor : root.getNeighbors()) {
            dfs(result, neighbor);
        }
    }

    public static void main(String[] args) {
        Tree tree = new DirectedTree();
        tree.addNodes(5, 4, 3);
        tree.addNodes(4, 1, -6);
        tree.addNodes(3, 0, 7, -4);
        tree.addNodes(1, 2, 9);
        tree.addNodes(7, 8);
        tree.markRoot(5);
        int totalSum = calculateLeafSum(tree);
        System.out.println("Total leaf sum for the tree is " + totalSum);
    }
}
