package com.algorithms.trees;

public class BinaryTreeInt {

	public Node root;
	
	public static class Node {
		public Node left, right;
		public int val;
		public Node(int v) {
			this.val = v;
		}
	}
	
	private Node add(Node node, int val) {
		if(node == null) {
			return new Node(val);
		}
		
		if(node.val > val) {
			node.left = add(node.left, val);
		} else if(node.val < val) {
			node.right = add(node.right,val);
		}
		return node;
	}
	
	public void add(int val) {
		root = add(root, val);
	}
	
	public void addIterative(int val) {
		if(root == null) {
			root = new Node(val);
			return;
		}
		
		Node previous = null;
		Node current = root;
		while(current != null) {
			previous = current;
			if(current.val > val) {
				current = current.left;
			} else if(current.val < val) {
				current = current.right;
			}
		}
		current = new Node(val);
		if(previous.val < current.val) {
			previous.right = current;
		} else {
			previous.left = current;
		}
		
	}
	
	
	public int maxHeight() {
		return 0;
	}
	
	public Node search(int val) {
		return null;
	}
	
	public Node min(Node root) {
		return null;
	}
	
	public Node max(Node root) {
		return null;
	}
	
	public void delete(int val)  {
		
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
