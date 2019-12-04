package com.algorithms.backtracking;

public class NQueensNew {

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

    public static void print(int arr[][]) {
        for(int i=0; i <  arr.length; i++) {
            for(int j=0; j < arr.length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println("\n");
        }
    }

    public static void queens(int arr[][], int row) {
        for(int col=0; col < arr.length; col++) {

            if(safe(row, col, arr)) {
                arr[row][col] = 1;
                if(row == arr.length-1) {
                    print(arr);
                    return;
                }
                queens(arr,row+1);
                arr[row][col] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int arr[][] = new int[4][4];
        queens(arr, 0);
    }

}
