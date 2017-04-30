package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrderTree {

	public static class Node {

		public Node(int d) {
			this.data = d;
		}

		public int data;
		public Node left;
		public Node right;
	}
	
	public static void printLevelOrderRecursive(Node root) {
		
		Queue<Node> currentLevel = new LinkedList<>();
		
		if(root != null) {
			currentLevel.add(root);
			printCurrentLevel(currentLevel);
		}
		
	}
	
	private static void printCurrentLevel(Queue<Node> nodes) {
		if(nodes.isEmpty()) {
			System.out.println("----Done-----");
			return;
		}
		
		Queue<Node> thisLevel = new LinkedList<>();
		
		while(!nodes.isEmpty()) {
			Node n = nodes.poll();
			System.out.print("\t "+ n.data);
			if(n.left != null) {
				thisLevel.offer(n.left);
			}
			
			if(n.right != null) {
				thisLevel.offer(n.right);
			}
			
		}
		
		System.out.println("\n");
		printCurrentLevel(thisLevel);
		
	}

	public static void printLevelOrder(Node root) {

		int levelCount = 1;

		Queue<Node> queue = new LinkedList<>();

		queue.offer(root);

		while (!queue.isEmpty()) {

			while (levelCount > 0) {
				Node n = queue.poll();

				System.out.print(n.data + " ");

				if (n.left != null) {
					queue.offer(n.left);
				}
				if (n.right != null) {
					queue.offer(n.right);
				}
				levelCount--;
			}
			System.out.println("\n");
			levelCount = queue.size();
		}

	}

	public static void printLevelOrderSentinel(Node root) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		Node sentinel = new Node(-99);
		queue.add(sentinel);
		boolean sentinelFound = false;
		while(!queue.isEmpty()) {
			Node q = queue.poll();
			
			if(q.data == -99) {
				System.out.println("\n");
				if(queue.isEmpty() == false) {
					queue.offer(sentinel);
				}
			} else {
				System.out.print(q.data + " ");
				if(!sentinelFound) {
					if(q.left != null) {
						queue.offer(q.left);
					}
					if(q.right != null) {
						queue.offer(q.right);
					}
				}
			}
			
		}
		
		

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintLevelOrderTree o = new PrintLevelOrderTree();
		Node root = new Node(66);
		Node l1 = new Node(6);
		Node r1 = new Node(87);
		Node l2 = new Node(54);
		Node r2 = new Node(94);
		Node l3 = new Node(12);
		Node r3 = new Node(92);

		Node l3r = new Node(57);

		Node r3r = new Node(96);

		root.left = l1;
		root.right = r1;

		l1.right = l2;
		r1.left = r2;

		l2.left = l3;

		r2.left = r3;
		l2.right = l3r;

		r2.right = r3r;

		printLevelOrder(root);
		System.out.println("-----");
		printLevelOrderSentinel(root);
		System.out.println("-----");
		printLevelOrderRecursive(root);

	}

}
