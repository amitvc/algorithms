package com.algorithms.practice2022.combinatorics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPerm {

    public static void perm(String s, String result) {

        if (s.isEmpty()) {
            System.out.println(result);
            return;
        }

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            String remainder = s.substring(0, i) + s.substring(i+1);
            perm(remainder, result+c);
        }
    }

    public static List<String> perm2(String s) {
        if (s.length() == 1) {
            return Arrays.asList(s);
        }

        List<String> finalResult = new ArrayList<>();
        for (int i=0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            String remainingStr = s.substring(0, i) + s.substring(i+1);
            List<String> result = perm2(remainingStr);
            for (String t : result) {
                finalResult.add(currentChar + t);
            }
        }
        return finalResult;
    }



    public static void main(String[] args) {
       // perm("abc", "");
        perm2("abc").stream().forEach(System.out::println);
    }
}
