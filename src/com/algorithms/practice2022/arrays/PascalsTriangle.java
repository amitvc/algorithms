package com.algorithms.practice2022.arrays;

import java.util.Arrays;

public class PascalsTriangle {

    /**
     * 1234554321  - 0
     * 1234**4321  - 1
     * 123****321  - 2
     * 12******21  - 3
     * 1********1  - 4
     * @param n
     */
    private static void printWeirdFormat(int n) {
        int rowCount = 0;
        while (rowCount < n) {
            int value = 1;

            while(value <= n) {
                extracted(n, value, value, rowCount);
                value++;
            }
            value--;
            while(value >= 1) {
                extracted(value, n, value, rowCount);
                value --;
            }
            System.out.println("");
            rowCount++;
        }
    }

    private static void extracted(int n, int value, int value1, int rowCount) {
        if (Math.abs(n - value) < rowCount) {
            System.out.print(Character.toChars(42));
        } else {
            System.out.print(value1);
        }
    }


    private static void print(int n) {
        int arr[][] = new int[n][n];
        arr[0][0] = 1;
        arr[1][0] = 1;
        arr[1][1] = 1;

        for (int i=2; i < n; i++) {
            for (int j=0; j <= i; j++) {
                if (j==0 || j == i) {
                    arr[i][j] = 1;
                } else {
                    arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                }
            }
        }
        System.out.println(Arrays.deepToString(arr).replace("[", "\n["));
    }


    public static void main(String[] args) {
        int n = 6;
        print(n);
        printWeirdFormat(5);
    }
}
