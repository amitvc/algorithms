package com.algorithms.trees;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarkCousins {
	public static class Node {
		private int data;
		public Node left;
		public Node right;
		public List<Integer> cousins;

		public Node(int v) {
			this.data = v;
			cousins = new ArrayList<>();
		}
	}


	public void dfs(Node r, int level, Map<Integer, List<Integer>> cousins) {
		if(r == null) {
			return;
		}

		if(!cousins.containsKey(level)) {
			cousins.put(level, new ArrayList<>());
		}
		List<Integer> current = cousins.get(level);
		r.cousins.addAll(current);
		current.add(r.data);
		int nextLevel = level+1;
		dfs(r.right, nextLevel, cousins);
		dfs(r.left, nextLevel,cousins);
	}


	public void markCousins(Node root) {
		dfs(root, 0, new HashMap<Integer, List<Integer>>());
		System.out.println(root);
	}

	/**
	 *                      75
	 *
	 *               50             100
	 *
	 *           45     60      80        120
	 *
	 *        30    48      61
	 *
	 *
	 *
	 * @param args
	 */


	public static void main(String args[]) {
		Node root = new Node(75);
		Node n50 = new Node(50);
		Node n100 = new Node(100);
		Node n45 = new Node(45);
		Node n60 = new Node(60);
		Node n80 = new Node(80);
		Node n120 = new Node(120);

		Node n30 = new Node(30);
		Node n48= new Node(48);
		Node n61 = new Node(61);


		root.left = n50;
		root.right = n100;

		n50.left = n45;
		n50.right = n60;

		n100.left = n80;
		n100.right = n120;

		n45.right = n48;
		n45.left = n30;

		n60.right = n61;

		MarkCousins m = new MarkCousins();
		m.markCousins(root);

	}



}
