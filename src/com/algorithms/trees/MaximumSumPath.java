package com.algorithms.trees;

public class MaximumSumPath {
	public int max;
	public int max_sum;
	public static class Node {
		public int val;
		public Node left, right;
		public Node(int v) {
			this.val = v;
		}
	}
	
	public int maxSumPath(Node r) {
		if(r == null) return 0;
		int left = maxSumPath(r.left);
		int right = maxSumPath(r.right);
		int current  = left+right+r.val;
		max = Math.max(max, current);
		max = Math.max(max, r.val);
		return Math.max(left, right) + r.val;
	}


	// Mistakes I made --
	// Not check for null pointer on node
	// Key insight - the MPS of the tree can be found in branches of the tree that
	// do not include the root. So you have to keep track of the max_sum while you are calculating the MPS

	public  int mps(Node root) {

		if (root != null && (root.left == null && root.right == null)) {
			return root.val;
		}

		if (root == null) return 0;


		int left = mps(root.left);
		int right = mps(root.right);

		max_sum = Math.max(max_sum, left+right+root.val);

		return Math.max(left, right) + root.val;
	}


	public static void main(String[] args) {
		MaximumSumPath ms = new MaximumSumPath();

		Node n1 = new Node(10);

		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n10 = new Node(10);


		n1.left = n2;
		n1.right = n3;

		n2.left = n4;
		n2.right = n5;

		n3.left = n6;
		n3.right= n7;

		n6.left = n8;

		n7.right = n10;


		ms.mps(n1);
		System.out.println("MPS " + ms.max_sum);
	}

}
