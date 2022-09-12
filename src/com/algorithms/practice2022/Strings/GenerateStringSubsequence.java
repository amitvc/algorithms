package com.algorithms.practice2022.Strings;

public class GenerateStringSubsequence {

    public static void main(String[] args) {
        generateSubsequence("abc", "");
    }

    private static void generateSubsequence(String s, String result) {
        if (s.isEmpty()) {
            System.out.println(result);
            return;
        }

        char c = s.charAt(0);
        generateSubsequence(s.substring(1) , result);
        generateSubsequence(s.substring(1) , result + c);
    }
}
