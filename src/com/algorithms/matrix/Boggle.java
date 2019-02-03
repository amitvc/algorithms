package com.algorithms.matrix;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Boggle {
	
	public static String[] wordBoggle(char[][] board, String[] words) {
	    boolean visited[][] = new boolean[board.length][board[0].length];
	    int rows = board.length;
	    int cols = board[0].length;
	    Set<String> ans = new TreeSet<>();
	    for(int i=0; i < rows; i++) {
	    	for(int j=0; j < cols; j++) {
	    		//Now we apply dfs to go and find all paths originating from here
	    		findWords("",board, words, rows, cols, i,j, visited, ans);
	    	}
	    }
	    String[] answers = new String[ans.size()];
	    int i=0;
	    for(String s : ans) {
	    	answers[i++] = s;
	    }
	    return answers;
	}

	private static void findWords(String current,char[][] board, String[] words, int rows, int cols, int x, int y, boolean[][] visited,
			Set<String> ans) {
		  if (x < 0 || y < 0 || x >= rows || y >= cols) return;
	        

	        // can't visited a cell more than once
	        if (visited[x][y]) return;

	        // key to efficiency of backtracking algorithm

	        // not allowed to reuse a letter
	        visited[x][y] = true;

	        // found a word
	        current = current + board[x][y];
	       
	        for(String w : words) {
	        	if(w.equals(current)) {
	        		ans.add(w);
	        	}
	        }

	        // consider all neighbors
	        for (int ii = -1; ii <= 1; ii++)
	            for (int jj = -1; jj <= 1; jj++)
	            	findWords(current, board, words, rows, cols, x+ii, y+jj, visited, ans);

	        //Now back track. Meaning mark this entry false because you are finally done exploring
	        // all paths starting from this point.
	        visited[x][y] = false;
	}


	public static void main(String[] args) {
		char board[][] = {
				{'R', 'L', 'D'},
				{'U', 'O', 'E'},
				{'C', 'S', 'O'}
		};
		
		String[] set = {"CODE", "SOLO", "RULES", "COOL"};
		
		String ans[] = wordBoggle(board, set);
		Arrays.stream(ans).forEach(System.out::println);
	}
}
