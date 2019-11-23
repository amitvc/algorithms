package com.algorithms.trees;


import java.util.*;

public class MarkCousins {
	public static class Node {
		private String data;
		public Node left;
		public Node right;
		public List<String> neighbors;

		public Node(String v) {
			this.data = v;
			neighbors = new ArrayList<>();
		}
	}


	public void traverse(Node r, int level, Map<Integer, List<String>> neighborhoodMap) {
		if(r == null) {
			return;
		}

		if(!neighborhoodMap.containsKey(level)) {
			neighborhoodMap.put(level, new ArrayList<>());
		}
		List<String> current = neighborhoodMap.get(level);
		r.neighbors.addAll(current);
		current.add(r.data);
		int nextLevel = level+1;
		traverse(r.right, nextLevel, neighborhoodMap);
		traverse(r.left, nextLevel,neighborhoodMap);
	}


	public void findNeighbors(Node root) {
		traverse(root, 0, new HashMap<Integer, List<String>>());
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
		Node root = new Node("Alan");
		Node lori = new Node("lori");
		Node vera = new Node("vera");
		Node bob = new Node("bob");
		Node troy = new Node("troy");
		Node jim = new Node("jim");
		Node ken = new Node("ken");

		Node nancy = new Node("nancy");


		root.left = lori;
		root.right = vera;
		lori.left = bob;
		bob.left = ken;

		vera.left = troy;
		vera.right = jim;

		jim.right = nancy;

		MarkCousins m = new MarkCousins();
		m.findNeighbors(root);
		System.out.println(root);
	}



}
