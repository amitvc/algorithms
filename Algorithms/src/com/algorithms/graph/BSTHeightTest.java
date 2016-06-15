package com.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BSTHeightTest {

	public class Node {
		public int data;
		public Node left, right;

		public Node(int d) {
			this.data = d;
			left = right = null;
		}
	}

	public Node insert(Node root, int data) {
		if (root == null) {
			return new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public int getHeight(Node root) {
		System.out.println("gh");
		if (root == null) {
			return -1;
		} else {
			int lh = getHeight(root.left);
			System.out.println("lh " + lh);
			int rh = getHeight(root.right);
			System.out.println("rh "+ rh);
			return lh > rh ? lh +1 : rh +1;
		}
	}
	
	public static int getHeightItr(Node root){
	      //Write your code here
	        if(root == null) {
	            return 0;
	        }
	        int height = 0;
	        Queue<Node> children = new LinkedList<Node>();
	        children.add(root);
	        while(true) {
	                      
	            int childCount = children.size();
	            if(childCount == 0) {
	                break;
	            }
	            int count = 0;
	            
	            while(count < childCount) {
	                Node temp = children.poll();
	                if(temp.left != null) {
	                    children.add(temp.left);
	                }
	                if(temp.right != null) {
	                    children.add(temp.right);
	                }
	                count++;
	            }
	           
	            height++; 
	        }
	        height--;
	        return height;
	    }

	
	public void levelOrder(Node root){
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node t = queue.poll();
			
			System.out.printf("%d ", t.data);
			if(t.left != null) {
				queue.add(t.left);
			} else if(t.right != null) {
				queue.add(t.right);
			}
		}
	}

	
	// 1,2,3,3,4,2,2,5
	//1,2,3,3,4,2,5
	
	public static void main(String[] args) {
		BSTHeightTest t = new BSTHeightTest();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Node root = null;
		while (T-- > 0) {
			int data = sc.nextInt();
			root = t.insert(root, data);
		}
		int height = t.getHeight(root);
		System.out.println("Height " + height);

	}

}
