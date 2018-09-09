package com.algorithms.trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Class is representation of a classic binary search tree.
 * It does not guarantee balanced tree at the end of the insertion operation. 
 * 
 * @author amit
 *
 */
public class BinaryTree {
	
	public Node root;
	
	public BinaryTree() {
		root = null;
	}
	
	
	public void addRec(int value) {
		Node current = root;
		root = addRec(current, value);
	}
	
	/**
	 * Recursive method to add node to binary tree.
	 * @param node
	 * @param value
	 * @return
	 */
	public Node addRec(Node node, int value) {
		if(node == null) {
			return new Node(value);
		}
		
		if(node.data <= value) {
			node.right = addRec(node.right, value);
		} else {
			node.left = addRec(node.left, value);
		}
		return node;
	}

	/**
	 * Iterative method to add a new node to the binary tree.
	 * @param value
	 */
	public void add(int value) {
		if(root == null) {
			root = new Node(value);
		} else {
			Node current = root;
			Node previous = null;
			while(current != null) {
				if(current.data <= value) {
					previous = current;
					current = current.right;
				} else {
					previous = current;
					current = current.left;
				}
			}
			
			if(previous.data <= value) {
				previous.right = new Node(value);
			} else {
				previous.left = new Node(value);
			}
		}
	}
	
	
	/**
	 * Method responsible to search for a node in the tree.
	 * @param value
	 * @return true if value present or false.
	 */
	public boolean isPresent(int value) {
		Node current = root;
		while(current != null) {
			if(current.data == value) return true;
			if(current.data <= value) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		return false;
	}
	
	public Node findNode(int value) {
		Node current = root;
		while(current != null) {
			if(current.data == value)  break;
			if(current.data <= value) {
				current = current.right;
			} else {
				current = current.left;
			}
		}
		return current;
	}
	
	
	public static Node deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        String[] parts = data.split(",");
        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(Integer.parseInt(parts[0]));
        queue.offer(root);
        int i = 1;
        while (i < parts.length) {
        	Node node = queue.poll();

            if (parts[i].equals("#")) {
                node.left = null;
            } else {
            	Node left = new Node(Integer.parseInt(parts[i]));
                node.left = left;
                queue.offer(left);
            }

            if (i + 1 == parts.length) break;

            if (parts[i + 1].equals("#")) {
                node.right = null;
            } else {
            	Node right = new Node(Integer.parseInt(parts[i + 1]));
                node.right = right;
                queue.offer(right);
            }
            i += 2;
        }
        return root;
    }
	
	
	public Node root() {
		return root;
	}
	
	private Node findMax(Node value) {
		return null;
	}
	
	private Node findMin(Node value) {
		return null;
	}
	
	public void delete(int value) {
		
	}
}
