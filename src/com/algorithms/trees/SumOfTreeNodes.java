package com.algorithms.trees;

import java.util.HashMap;
import java.util.Map;

public class SumOfTreeNodes {
	
	
	public static int sumOfTree(Node r) {
		if(r == null) return 0;
		int left = sumOfTree(r.left);
		int right = sumOfTree(r.right);
		return left+right + r.data;
	}

	public static void main(String[] args) {
		Node n = BinaryTree.deserialize("3,9,20,#,#,15,7,#,#,#,#");
		System.out.println(sumOfTree(n));
	}

}
