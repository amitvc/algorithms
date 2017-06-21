package com.algorithms.practice;

public class LinkedListClone {

	public static class Node {
		public int data;
		public Node next, random;

		public Node(int d) {
			this.data = d;
		}
	}

	public static Node cloneListUsingHashing(Node start) {
		return null;
	}

	public static Node cloneListWithoutHashing(Node current) {
		Node cloneStart = null;
		Node root = current;
		
		while (current != null) {
			Node newNode = new Node(current.data);
			Node temp = current.next;
			current.next = newNode;
			newNode.next = temp;
			current = temp;
		}
		
		current = root;
		while (current != null) {
			current.next.random = current.random.next;
			current = current.next.next;
		}
		
		current = root;
		Node secondCurrent = root.next;
		cloneStart = root.next;
		while(current != null && secondCurrent != null) {
			current.next = current.next != null ? current.next.next : current.next;
			secondCurrent.next = secondCurrent.next != null ?secondCurrent.next.next:secondCurrent.next;
	        current = current.next;
	        secondCurrent = secondCurrent.next;
		}
		return cloneStart;
	}

	public static void print(Node start) {
		while (start != null) {
			System.out.println(String.format("Node %d next %d random %d %s", start.data,
					start.next != null ? start.next.data : 0, start.random.data, start.toString()));
			start = start.next;
		}
	}

	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		five.next = null;

		one.next = two;
		two.next = three;
		three.next = four;
		four.next = five;

		one.random = three;
		two.random = four;
		three.random = five;
		four.random = one;
		five.random = two;

		Node start = one;
		LinkedListClone.print(start);
		Node clone = LinkedListClone.cloneListWithoutHashing(start);
		LinkedListClone.print(clone);

	}

}
