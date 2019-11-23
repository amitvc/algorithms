package com.algorithms.trees;

import java.util.Arrays;

public class PostOrderToBST {



    public static class Index
    {
        int postindex = 0;
    }

    public static Node createBST(int values[], Index currentIndex, int min, int max) {

        // Base case
        if (currentIndex.postindex < 0)
            return null;

        // Return if next element of postorder traversal from the end
        // is not in valid range
        int curr = values[currentIndex.postindex];
        if (curr < min || curr > max)
            return null;

        Node root = new Node(values[currentIndex.postindex]);
        currentIndex.postindex--;

        root.right = createBST(values,currentIndex, root.data+1, max );
        root.left =  createBST(values, currentIndex, min, root.data-1);
        return root;
    }


    /**
     *
     *    [2, 4, 3, 8, 7, 5]
     *
     *           5 --> root
     *               5->left =
     *                             [2, 4, 3, 8, 7]
     *
     *                                    7->left
     *                                       [2,4,3,8]
     *                                           8->left
     *                                                 [2,4,3]
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */






    /**
     *            5
     *          /   \
     *       3       7
     *     /  \       \
     *   2     4       8
     *
     */

    public static void main(String args[]) {
        int arr[] = {2, 4, 3, 8, 7, 5};
        Index index = new Index();
        index.postindex = arr.length - 1;
        Node r = createBST(arr, index, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println("root " + r);
    }
}
