package com.algorithms.strings;

import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class LongestPalindromicString {

    public String getPalindrome(String s) {

        String result = "";

        for(int i=0; i < s.length(); i++) {

            if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                String rc = getPalindrome(s, i, i+1);
                result = rc.length() > result.length() ? rc : result;
            } else {
                String rc = getPalindrome(s,i,i);
                result = rc.length() > result.length() ? rc : result;
            }

        }

        return result;

    }

    // aba

    public String getPalindrome(String s, int l, int r) {

        while(l >= 0 && r < s.length()) {

            if(s.charAt(l) != s.charAt(r)) {

                return s.substring(l+1, r); // return l+1 because we don't want to include character at l and since substring excludes char at r we don't have to do r-1
            } else {

                l--;
                r++;
            }
        }

        return s.substring(l+1, r);

    }

    public static void main(String[] args) {
        LongestPalindromicString s = new LongestPalindromicString();
        String result = s.getPalindrome("cbbaabbc");
        System.out.println("Result " + result);
    }
}
