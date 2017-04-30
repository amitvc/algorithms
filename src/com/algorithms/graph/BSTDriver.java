package com.algorithms.graph;

public class BSTDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(11);
		bst.insert(6);
		bst.insert(8);
		bst.insert(19);
		bst.insert(4);
		bst.insert(10);
		bst.insert(5);
		bst.insert(17);
		bst.insert(43);
		bst.insert(49);
		bst.insert(31);

		bst.inOrderSearchRecursive(bst.root);
		System.out.println("Amit");
	}

}
