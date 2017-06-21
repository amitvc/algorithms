package com.algorithms.linkedlist;

public class MergeList {
	
	public static class Node {
		
		public Node(int d, Node n) {
			this.data = d;
			next = n;
		}
		public  int data;
		public Node next;
	}
	
	public static Node mergeListRecursive(Node l1, Node l2) {
		Node result = null;
		if(l1 == null && l2 == null) {
			return null;
		}
		
		if(l1 == null) {
			return l2;
		}
		
		if(l2 == null) {
			return l1;
		}
		
		if(l1.data <= l2.data) {
			result = l1;
			result.next = mergeList(l1.next, l2);
		} else {
			result = l2;
			result.next = mergeList(l1, l2.next);
		}
		return result;
		
	}
	
	public static Node mergeList(Node l1, Node l2) {
		
		Node previous = null;
		Node root = null;
		while(l1 != null && l2 != null) {
			
			if(l1.data <= l2.data) {
				if(previous != null) {
					previous.next = l1;
					previous = l1;
				} else {
					previous = l1;
				}
				l1 = l1.next;

			} else {
				if(previous != null) {
					previous.next = l2;
					previous = l2;
				} else {
					previous = l2;
				}
				l2 = l2.next;
			}
			
			if(root == null) {
				
				root = previous;
			}
		}
		if(l1 == null) {
			previous.next = l2;
		} else {
			previous.next = l1;
		}
		return root;
	}

	
	/**
	 *   1->3->7
	 *   2->4->5
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Node seven = new Node(7,null);
		Node three = new Node(3,seven);

		Node root1 = new Node(1,three);
		
		Node five = new Node(5, null);
		Node four = new Node(4, five);
		
		
		Node root2 = new Node(2, four);
		
	//	Node merged = mergeList(root1, root2);
		System.out.println("");
		
		Node mergedRec = mergeListRecursive(root1, root2);
		System.out.println(mergedRec.data);
		
	}

}
