package com.algorithms.practice2022.arrays;

public class RunLengthEncoding {

    public static String getRunLengthCode(String input) {
        int multiplier = 1;
        int i = 1;
        StringBuilder sb = new StringBuilder();
        while (i < input.length()) {
            if (input.charAt(i-1) == input.charAt(i)) {
                multiplier++;
            } else {
                sb.append(multiplier).append(input.charAt(i-1));
                multiplier = 1;
            }
            i++;
        }
        sb.append(multiplier).append(input.charAt(i-1));
        return sb.toString();
    }

    public static String getRunLengthCode1(String input) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while ( i < input.length()) {

            int j = i+1;
            while (j < input.length() && (input.charAt(j) == input.charAt(i))) {
                j++;
            }
            sb.append(j-i).append(input.charAt(i));
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = "AAACCBBBABCCDXYZ";
        String output = getRunLengthCode(input);
        System.out.println("RunLength(Code) " + output);
        System.out.println("RunLengthCode1  " + getRunLengthCode1(input));
    }
}
