package com.algorithms.practice2022.Strings;

import java.util.concurrent.atomic.AtomicInteger;

public class DecodeString {

    public static String decodeRecursive(String s) {
        return decodeRecursive(s, new AtomicInteger(0));
    }

    private static String decodeRecursive(String s, AtomicInteger idx) {
        String current = "";
        while (idx.get() < s.length()) {
            int multiplier = 0;
            if (Character.isDigit(s.charAt(idx.get()))) {
                String multiplierText = "";
               while(Character.isDigit(s.charAt(idx.get()))) {
                   multiplierText += s.charAt(idx.get());
                   idx.getAndIncrement();
               }
               multiplier = Integer.parseInt(multiplierText);
            }

            if (s.charAt(idx.get()) == '[') {
                idx.getAndIncrement();
               String value = decodeRecursive(s, idx);
               StringBuilder sb = new StringBuilder();
               while (multiplier > 0) {
                   sb.append(value);
                   multiplier--;
               }
               current += sb.toString();
            }

            if (s.charAt(idx.get()) == ']') {
                idx.getAndIncrement();
                return current;
            }

            current += s.charAt(idx.getAndIncrement());
        }
        return current;
    }

    public static void main(String[] args) {
        System.out.println(decodeRecursive("2[ab]"));
    }
}
