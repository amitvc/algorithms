package com.algorithms.list;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class LinkedList {

	public static class Node {
		public int data;
		public Node next;
		public Node(int v) {
			data = v;
			next = null;
		}
	}
	
	
	/**
	 * Reverses an existing linkedlist.
	 * The expected parameter is the root of the list
	 * @param n
	 */
	public static Node reverse(Node n) {
		Node previous = null;
		Node next = null;
		while(n != null) {
			next = n.next;
			n.next = previous;
			previous = n;
			n = next;
		}
		return previous;
	}
	
	public static Node removeDups(Node head) {
		if(head == null) {
            return head;
        }
        
        for(Node t = head; t != null; t = t.next) {
            Node p = t;
            for(Node n = t.next; n != null; n = n.next){
                if(n.data == t.data) {
                    p.next = n.next;
                } else {
                    p = n;    
                }
            }
        }
		return head;
	}
	
	public static void main(String[] args) throws IOException {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = new Node(4);
		//root.next.next.next.next = new Node(2);
		//root.next.next.next.next.next = new Node(2);
		root.next.next.next.next = new Node(5);
	//	Node t = removeDups(root);
		Node newRoot = reverse(root);
		System.out.println("");
	}

}
