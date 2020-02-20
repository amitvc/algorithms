package com.algorithms.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuffixArray {

    public static class Suffix {
        public String value;
        public int index;
    }


    public static int[][] suffixArray(String s) {


        List<Suffix> suffixes = new ArrayList<>();

        for (int i=0; i < s.length(); i++) {
            Suffix sf = new Suffix();
            sf.index = i;
            sf.value = s.substring(i);
            suffixes.add(sf);
        }

        Collections.sort(suffixes, (s1, s2) -> {
            return s1.value.compareTo(s2.value);
        });



        int array[][] = new int[suffixes.size()][2];

        int i=0;
        for(Suffix sf : suffixes) {
            array[i++][0] = sf.index;
        }

        i=0;
        for(Suffix sf : suffixes) {
            if (i == 0) {
                array[i++][1] = 0;
                continue;
            }

            Suffix previousSf = suffixes.get(i-1);
            int j;
            for (j=0; j < sf.value.length() && j < previousSf.value.length(); j++) {
                if (previousSf.value.charAt(j) != sf.value.charAt(j))
                    break;
            }

            array[i++][1] = j;
        }


        return array;

    }


    public static void main(String[] args) {
        String str = "ABABBAB";

        int arr[][] = suffixArray(str);

        System.out.println("Suffix array  LCP Array");

        for (int i=0; i < arr.length; i++) {
            System.out.println("\t" + arr[i][0] + "\t \t \t" + arr[i][1]);
        }
    }
}
