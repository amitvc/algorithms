package com.algorithms.trees;


public class InvertBinaryTree {
	
	public static class Node {
		public Node left, right;
		public int val;
		public Node(int v) {
			this.val = v;
		}
	}
	
	public static void invert(Node n) {
		if(n == null) {
			return;
		}
		//Invert my left subtree first
		invert(n.left);
		// Then invert my right subtree
		invert(n.right);
		//If i come here it means my left and right child subtrees 
		//are already inverted and now
		// my task is to simply swap my children 
		Node temp = n.left;
		n.left = n.right;
		n.right = temp;
	}

	public static void main(String[] args) {
		Node n20  = new Node(20);
		Node n35 = new Node(35);
		Node n15 = new Node(15);
		Node n10 = new Node(10);
		Node n18 = new Node(18);
		Node n40 = new Node(40);
		
		n20.left = n15;
		n20.right = n35;
		n15.left = n10;
		n15.right = n18;
		n35.right = n40;
		invert(n20);
	}

}
