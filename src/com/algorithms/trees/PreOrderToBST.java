package com.algorithms.trees;



public class PreOrderToBST {

    /* Construct below BST
			  15
			/	\
		   /	  \
		  10	   20
		 /  \	 /  \
		/	\   /	\
	   8	 12 16	25
	*/



    public static class Index
    {
        int idx = 0;
    }

    public static Node createBST(int values[], Index currentIndex, int min, int max) {


        if(currentIndex.idx >= values.length) {
            return null;
        }

        int currentValue = values[currentIndex.idx];

        if(currentValue < min || currentValue > max) {
            return null;
        }

        Node r = new Node(currentValue);
        currentIndex.idx++;
        r.left = createBST(values, currentIndex, min, r.data-1);
        r.right = createBST(values, currentIndex, r.data+1, max);
        return r;
    }



    public static void main(String args[]) {
        int arr[] = {15, 10, 8, 12, 20, 16, 25 };
        Index current = new Index();
        current.idx = 0;
        Node r = createBST(arr, current, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(r);
    }
}
