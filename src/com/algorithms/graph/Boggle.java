package com.algorithms.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 	Boggle {

	
	public static Map<String, String> dictionary = new HashMap<>();
	private static int N = 3;
	static {
		dictionary.put("GEEK", "GEEK");
		dictionary.put("GEEKS", "GEEKS");
		dictionary.put("QUIZ", "QUIZ");
		dictionary.put("SEEK", "SEEK");
	}
	
	
	private static void dfs(String prefix, int row, int col, boolean visited[][], char board[][]) {
        if (row < 0 || col < 0 || row >= N || col >= N) return;
        

        // can't visited a cell more than once
        if (visited[row][col]) return;

        // key to efficiency of backtracking algorithm

        // not allowed to reuse a letter
        visited[row][col] = true;

        // found a word
        prefix = prefix + board[row][col];
        if (dictionary.containsKey(prefix)) 
            System.out.println(prefix);

        // consider all neighbors
        for (int ii = -1; ii <= 1; ii++)
            for (int jj = -1; jj <= 1; jj++)
                dfs(prefix, row + ii, col + jj,visited,board);

        visited[row][col] = false;
    }
	
	
	public static void findBoggle(char [][] board) {
		boolean visited[][] = new boolean[board.length][board.length];
		// Note the words 2d array is square matrix (no of rows == no of cols)
		for(int row = 0; row < board.length; row++) {
			for(int col = 0; col < board.length; col++) {
				dfs("", row, col, visited,board);
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
		char board[][] = {{'G','I','Z'},
							{'U','E','K'},
							{'Q','S','E'}};
		findBoggle(board);
	}
}
