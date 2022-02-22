package com.algorithms.practice2022.combinatorics;

public class StringPerm {

    public static void perm(String s, String result) {

        if (s.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            String remainder = s.substring(0, i) + s.substring(i+1);
            System.out.println("r " + remainder);
            perm(remainder, result+c);
        }
    }



    public static void main(String[] args) {
        perm("abc", "");
    }
}
