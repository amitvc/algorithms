package com.algorithms.practice2022.talabat;

import java.util.Arrays;

public class LongestConcatenatedString {

    public static String findLongestString(String [] input) {
        Arrays.sort(input);
        return "";
    }


    public static void main(String[] args) {
        String arr[] = {"geeks", "for", "geeksfor", "geeksforgeeks"};
        String out = findLongestString(arr);
        System.out.println("out = " + out);
    }
}
