package com.algorithms.practice2022.matrices;

public class UniquePaths {

    /**
     *
     *
     * 0 1 1
     * 1 2 3
     * 1 3 6
     *
     *
     * @param row
     * @param cols
     * @return
     */
    public static int uniquePaths(int row, int cols) {
        if (row == 0 || cols == 0) {
            return 1;
        }
        if (row < 0 || cols < 0) {
            return 0;
        }

        return uniquePaths(row-1, cols) + uniquePaths(row, cols-1);
    }


    public static void main(String[] args) {
        System.out.println(uniquePaths(2,6));
    }
}
