package com.algorithms.trees;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.addRec(100);
		bt.addRec(20);
		bt.addRec(444);
		bt.addRec(120);
		bt.addRec(300);
		bt.addRec(12);
		System.out.println(bt.isPresent(30));
		System.out.println(bt.isPresent(300));
		
		System.out.println(bt.findNode(12).data);
	}

}
