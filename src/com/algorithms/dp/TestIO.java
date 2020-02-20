package com.algorithms.dp;

import java.util.Stack;

public class TestIO {

    public static String decodeString(String s) {
        Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        String current = "";
        int multiplier = -1;
        while (i < s.length()) {

            if (s.charAt(i) == ']') {
                int counter = count.pop();
                StringBuilder t = new StringBuilder();
                for(int j=0;  j < counter; j++){
                    t.append(current);
                }
                i++;
                current = result.pop()+t.toString();
            } else if (s.charAt(i) == '[') {
                count.push(multiplier);
                result.push(current);
                current = "";
                multiplier = -1;
                i++;
            } else if (Character.isDigit(s.charAt(i))) {
                String num ="";
                while(Character.isDigit(s.charAt(i))) {
                    num += s.charAt(i);
                    i++;
                }
                multiplier = Integer.parseInt(num);
            } else {
                current += s.charAt(i++);
            }
        }

        return result.pop();
    }

    public static void main(String[] args) {
        decodeString("3[a]2[bc]");
    }
}
