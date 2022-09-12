package com.algorithms.practice2022.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.algorithms.practice2022.trees.BinaryTree.BinaryTreeNode;

public class VerticalOrderTreeTraversal {

    public static List<List<String>> getVerticalOrder(BinaryTreeNode root) {
        Map<Integer, List<String>> result  = new HashMap<>();
        getVerticalOrder(root, 0, result);
        return result.values().stream().collect(Collectors.toList());
    }

    private static void getVerticalOrder(BinaryTreeNode root, int lane, Map<Integer, List<String>>result) {
        if (root == null) {
            return;
        }

        if (!result.containsKey(lane)) {
            result.put(lane, new ArrayList<>());
        }

        List<String> current = result.get(lane);

        current.add("" +root.getValue());

        getVerticalOrder(root.getLeft(), lane -1, result);
        getVerticalOrder(root.getRight(), lane + 1 , result);
    }


    public static void main(String[] args) {
        BinaryTreeNode root = BinaryTreeSerializer.deserializeTree("3,9,#,#,20,15,#,#,7,#,#");
        List<List<String>> result = getVerticalOrder(root);
        System.out.println(result.toString());
        root = BinaryTreeSerializer.deserializeTree("3,9,4,#,#,0,5,#,#,2,#,#,8,1,#,#,7,#,#");
        result = getVerticalOrder(root);
        System.out.println(result.toString());
    }
}
