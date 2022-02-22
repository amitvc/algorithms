package com.algorithms.practice2022.trees;

public class RootingTreeProblem {

    public static void main(String[] args) {
        Tree tree = new UnDirectedTree();
        tree.addNodes(0, 1, 5, 2);
        tree.addNodes(5, 4, 6);
        tree.addNodes(2, 3);
        System.out.println(tree);
    }
}
