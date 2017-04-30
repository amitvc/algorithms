package com.algorithms.basic;

import java.util.Scanner;

public class DecimalToBinary {
    public static void decimalToBinary(int n){
        if(n > 1){
            decimalToBinary(n / 2);
        }
        System.out.print(n & 1);
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.close();
        
        decimalToBinary(n);
    }
}