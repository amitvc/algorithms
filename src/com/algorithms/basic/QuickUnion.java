package com.algorithms.basic;

/**
 * QuickUnion algorithm which is used whether two or more nodes connected.
 * running times -
 * union - n
 * connected - n
 * @author amitvc
 *
 */
public class QuickUnion {
	int elements[];
	
	/**
	 * initialize the array and also elements.
	 * Initially all elements will be initialized to the their own
	 * index value.
	 * @param SIZE
	 */
	public QuickUnion(int SIZE) {
		elements = new int[SIZE];
		for(int i=0; i<SIZE; i++) {
			elements[i] = i;
		}
	}
	
	
	public int root(int p) {
		while(elements[p] != p) {
			p = elements[p];
		}
		return p;
	}
	
	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {
		int child = root(p);
		int parent = root(q);
		elements[child] = parent;
	}
	
	public static void main(String[] args) {
		QuickUnion qUnion = new QuickUnion(10);
		qUnion.union(3, 4);
		qUnion.union(4, 9);
		qUnion.union(2, 9);
		System.out.println("Connected " + qUnion.connected(3, 9));
	}

}
