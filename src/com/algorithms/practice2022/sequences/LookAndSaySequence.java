package com.algorithms.practice2022.sequences;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class LookAndSaySequence {


    /**
     * 1,
     * 11,
     * 21,
     * 1211,
     * 111221,
     * 312211,
     * 13112221,
     * 1113213211
     * 31131211121221
     * @param n
     * @return
     */
    public static String sequence(int n) throws IOException {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }

        String current = "11";
        int count = 2;

        Writer fileWriter = new FileWriter("/tmp/sequence.txt");

        while(count < n) {
            String next = "";
            int i = 1;
            int multiplier = 1;

            while(i < current.length()) {
                if (current.charAt(i-1) == current.charAt(i)) {
                    multiplier++;
                } else {
                    next+= "" + multiplier + current.charAt(i-1); // append the current multiplier + current char.
                    multiplier = 1; // reset the multiplier
                }
                i++;
            }
            next+= "" + multiplier + current.charAt(i-1);
            current = next;
            fileWriter.write(current);
            count++;
        }
        fileWriter.close();
        return current;
    }
    public static void main(String[] args) throws IOException {
        long st = System.currentTimeMillis();
        System.out.println(sequence(100));
        System.out.println(" Done printing after " + (System.currentTimeMillis() - st) + " ms");
    }
}
