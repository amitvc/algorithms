package com.algorithms.backtracking;


/**
 * N-Queens problem - Given a chess board which is n*n place queen on each row so that it does not collide with other queens on remaining rows.
 * This is classic example of backtracking technique.
 * @author amit
 *
 */
public class Queens2D {

	public static boolean safe(int row, int col, int a[][]) {
		for(int i=0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if(a[i][j] == 1) {
					if(row == i) return false;
					if(col == j) return false;
					if(Math.abs(row -i) == Math.abs(col-j)) return false;
				}
			}
		}
		return true;
	}
	
	public static void queens(int a[][], int row, int column) {
		for(int i=0; i < column; i++) {
			if(safe(row, i, a)) {
				a[row][i] = 1;
				if(row == column-1) {
					print(a);
				} else {
					queens(a, row+1, column);
					a[row][i] = 0;
				}
			}
		}
	
	}
	
	private static void print(int[][] a) {
		for(int i=0; i < a.length; i++) {
			for(int j = 0; j < a.length;j++) {
				System.out.print(" "+a[i][j]);
			}
			System.out.println("");
		}		
	}

	public static void main(String[] args) {
		int size = 8;
		int board[][] = new int[size][size];
		for(int i=0; i < board.length; i++) {
			for(int j = 0; j < board.length;j++) {
				board[i][j] = 0;
			}
		}
		
		queens(board, 0,size);
	}

}
