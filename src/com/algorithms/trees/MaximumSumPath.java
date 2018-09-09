package com.algorithms.trees;

public class MaximumSumPath {
	public int max;
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

	public static void main(String[] args) {
	}

}
