package com.algorithms.graph;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
	
	public Node<T> root;
	
	public class Node<T extends Comparable<T>> {
		private T data;
		private Node<T> right;
		private Node<T> left;

		public Node(T val, Node r, Node l) {
			this.data = val;
			this.right = r;
			this.left = l;
		}

		public Node(T data) {
			this(data, null, null);
		}

		public Node<T> left() {
			return left;
		}

		public Node<T> right() {
			return right;
		}
		
		public T data() {
			return data;
		}

	}

	public void insert(T val) {
		Node newNode = new Node<>(val, null, null);
		if(root == null) {
			root = newNode;
			return;
		}
	
		
		Node runnerNode = root;
		while(true) {
			int rc = runnerNode.data().compareTo(val);
			if(rc < 0) {
				if(runnerNode.right() != null) {
					runnerNode = runnerNode.right();
				} else {
					runnerNode.right = newNode;
					break;
				}
			} else if(rc > 0) {
				if(runnerNode.left() != null) {
					runnerNode = runnerNode.left();
				} else {
					runnerNode.left = newNode;
					break;
				}
			} else {
				// TODO dont add since its already added.
			}
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Queue<Node> queue = new LinkedList<>();
		queue.add(root);
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			//System.out.printf("Node %d ln %d rn %d", node.data(), node.left().data(), node.right().data());
			if(node != null) {
				sb.append("\n"+node.data() + "\n");
			}
			if(node.left() != null) {
				queue.add(node.left);
			}  
			if(node.right() != null) {
				queue.add(node.right);
			}
		}
		
		return sb.toString();
	}

	public void delete(T val) {

	}

	public Node<T> search(T val) {
		Node temp = root;
		return findNodeItr(val);
	}
	
	public Node<T> findNodeRecursive(Node node, T val) {
		if(node == null) 
			return null;
		if(node.data.compareTo(val) == 0) {
			return node;
		}
		if(node.data.compareTo(val) < 0) {
			return findNodeRecursive(node.right(), val);
		} else {
			return findNodeRecursive(node.left(), val);
		}
	}
	
	public Node<T> findNodeItr(T val) {
		Node t = root;
		while(t != null) {
			if(t.data().compareTo(val) == 0) {
				break;
			} else if(t.data().compareTo(val) < 0) {
				t = t.right();
			} else if(t.data().compareTo(val) > 0) {
				t = t.left();
			}
		}
		return t;
	}

	public void inOrderSearchRecursive(Node t) {
		if(t == null) return;
		inOrderSearchRecursive(t.left);
		System.out.print("\t"+t.data().toString());
		inOrderSearchRecursive(t.right);
	}

	public void inOrderSearchNonRecursive() {

	}

	public void postOrderSearchRecursive() {

	}

	public void postOrderSearchNonRecursive() {

	}
	
	public void preOrderSearchRecursive() {

	}

	public void preOrderSearchNonRecursive() {

	}

}
