package com.algorithms.backtracking;

import java.io.File;
import java.io.FileFilter;
import java.util.Iterator;
import java.util.List;

public class QueenAll {
	
	public static boolean isSafe(int a[][], int row, int col) {
		FileFilter fl = (File f) -> f.getName().endsWith(".java");
		return true;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[][] = {{0,0,1,0},{0,0,0,0}, {0,0,0,0},{0,0,0,0}};
		List<String> s;
		
		System.out.println(isSafe(a,1,1));

	}

}
