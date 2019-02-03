package com.algorithms.dp;

public class LongestIncreasingPathMatrix {
	
	public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int res = 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = dfs(matrix, Integer.MIN_VALUE, i, j, m, n, cache);
                res = Math.max(res, max);
            }
        }
        return res;
    }

    private static int dfs(int[][] matrix, int min, int i, int j, int m, int n, int[][] cache) {
        if (i < 0 || j < 0 || i >= m || j >= n || matrix[i][j] <= min) {
            return 0;
        }
        if (cache[i][j] != 0) {
            return cache[i][j];
        }
        min = matrix[i][j];
        int a = dfs(matrix, min, i - 1, j, m, n, cache) + 1;
        int b = dfs(matrix, min, i + 1, j, m, n, cache) + 1;
        int c = dfs(matrix, min, i, j - 1, m, n, cache) + 1;
        int d = dfs(matrix, min, i, j + 1, m, n, cache) + 1;
        int max = Math.max(a, Math.max(b, Math.max(c, d)));
        cache[i][j] = max;
        return max;
    }
    
    public static int longestIncreasingPaths(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j)
                ans = Math.max(ans, dfs(matrix, i, j));
        return ans;
    }
    
    private static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};


    private static int dfs(int[][] matrix, int i, int j) {
    	int max =0;
    	for (int[] d : dirs) {
            int x = i + d[0], y = j + d[1];
            if (0 <= x && x < matrix.length && 0 <= y && y <matrix[0].length && matrix[x][y] > matrix[i][j]) 
                max = Math.max(max, dfs(matrix, x, y)+1);
    	}
        return max;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] ={ 
                { 1, 2, 3, 4 }, 
                { 2, 2, 3, 4 }, 
                { 3, 2, 3, 4 }, 
                { 4, 5, 6, 7 }, 
              }; 
		System.out.println(longestIncreasingPath(matrix));
		System.out.println(longestIncreasingPaths(matrix));
	}

}
