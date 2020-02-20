package com.algorithms.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestStringChain {

    public static int longestStringChain(String words[]) {

        Map<String, Integer> edges = new HashMap<>();

        Set<String> lookup = new HashSet<String>(Arrays.asList(words));

        int maxSize = Integer.MIN_VALUE;
        for (String word : words) {

            for (int i=0; i < word.length(); i++) {
                if (word.length() == 1) {
                    edges.put(word, 1);
                    continue;
                }
                String maybe = word.substring(0,i) + word.substring(i+1);
                if (lookup.contains(maybe)) {
                    edges.put(word, Math.max(edges.get(maybe)+1, edges.computeIfAbsent(word, k -> 0)));
                    maxSize = Math.max(maxSize, edges.get(word));
                }
            }
        }

        System.out.println(maxSize);
        return maxSize;

    }

    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStringChain(words));
    }
}
