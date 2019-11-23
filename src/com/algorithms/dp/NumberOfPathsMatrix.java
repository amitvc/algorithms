package com.algorithms.dp;

public class NumberOfPathsMatrix {



    public static int numberOfWays(int r, int c) {

        if (r < 0 || c < 0) return 0;

        if (r == 0 || c == 0) return 1;

        return numberOfWays( r-1,c) + numberOfWays( r, c-1);
    }


    public static void main(String args[]) {
        System.out.println("Ways " + numberOfWays(2,3));
    }
}
