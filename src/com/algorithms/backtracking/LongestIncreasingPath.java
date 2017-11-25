package com.algorithms.backtracking;

public class LongestIncreasingPath {
	/*
	public static int longestIncreasingPath(int arr[][]) {
		int maxPath = Integer.MIN_VALUE;
		boolean visited[][] = new boolean[arr.length][arr.length];
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr.length; j++) {
				int currentElement = arr[i][j];
				maxPath = Math.max(maxPath, dfs(arr, i, j, Integer.MAX_VALUE));
			}
		}
		
		return maxPath;
	}

	private static int dfs(int[][] arr, int i, int j, int prev) {
		if(i<0 || j<0) return 0;
		if(i > arr.length-1 || j > arr.length-1) return 0;
		if(prev < arr[i][j]) return 0;
		int tempMax = 0;
		int current = arr[i][j];
		tempMax = Math.max(dfs(arr, i+1, j, current), tempMax);
        tempMax = Math.max(dfs(arr,  i,j+1, current), tempMax);
        tempMax = Math.max(dfs(arr, i-1, j, current), tempMax);
        tempMax = Math.max(dfs(arr, i, j-1, current), tempMax);
		return 1 + tempMax;
	}*/

	
	 public static int longestIncreasingPath(int[][] matrix) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return 0;
	        }
	        int max = 0;
	        for (int i = 0; i < matrix.length; i++) {
	            for (int j = 0; j < matrix[0].length; j++) {
	                int length = findSmallAround(i, j, matrix, Integer.MAX_VALUE);
	                max = Math.max(length, max);
	            }
	        }
	        return max;
	    }
	    private static int findSmallAround(int i, int j, int[][] matrix, int pre) {
	        // if out of bond OR current cell value larger than previous cell value.
	       // if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] >= pre) {
	        //	System.out.println(String.format("i=%d j=%d pre=%d",i,j, pre));
	        //    return 0;
	       // }
	    	
	    	//if(i<0 || j<0 || i > matrix.length-1 || j > matrix.length-1 || pre < matrix[i][j]) return 0;
			//if(i > matrix.length-1 || j > matrix.length-1) return 0;
			//if(pre < matrix[i][j]) return 0;
	        // if calculated before, no need to do it again
	       
	            int cur = matrix[i][j];
	            int tempMax = 0;
	            tempMax = Math.max(findSmallAround(i - 1, j, matrix, cur), tempMax);
	            tempMax = Math.max(findSmallAround(i + 1, j, matrix, cur), tempMax);
	            tempMax = Math.max(findSmallAround(i, j - 1, matrix, cur), tempMax);
	            tempMax = Math.max(findSmallAround(i, j + 1, matrix, cur), tempMax);
	            return tempMax+1;

	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 int arr[][] = {
				 		{9,9,4},
				 		{6,6,8},
				 		{2,1,1}
				 		};
		 System.out.println(longestIncreasingPath(arr));
	}

}
