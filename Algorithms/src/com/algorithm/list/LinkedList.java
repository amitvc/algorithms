package com.algorithm.list;

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
		root.next.next.next.next = new Node(2);
		root.next.next.next.next.next = new Node(2);
		root.next.next.next.next.next.next = new Node(5);
		Node t = removeDups(root);
		System.out.println(t);
		ServerSocket soc = new ServerSocket(9000);
		Socket soc2 = new Socket("localhost", 9000);
		Socket soc22 = new Socket("localhost", 9000);

	}

}
