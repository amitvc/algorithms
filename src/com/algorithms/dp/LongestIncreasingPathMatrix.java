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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix[][] = new int[1][2];
		matrix[0][0] = 1;
		matrix[0][1] = 2;
		System.out.println(longestIncreasingPath(matrix));
	}

}
