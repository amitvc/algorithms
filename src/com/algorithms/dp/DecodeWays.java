package com.algorithms.dp;


public class DecodeWays {




    public static int ways(String s) {

        if (s.isEmpty()) return 1;

        if (s.length() == 1) {
            return 1;
        }

        int w1 =  ways(s.substring(1));

        int w2 = 0;
        if (s.length() >= 2 && Integer.parseInt(s.substring(0,2)) < 27) {
            w2 = ways(s.substring(2));
        }

        return w1+w2;
    }


    public static void main(String args[]) {
        System.out.println(ways("2226"));

        // 2 2 2 6
        // 22 26
        // 22 2 6
        //2 22 6
        // 2 2 26
    }
}
