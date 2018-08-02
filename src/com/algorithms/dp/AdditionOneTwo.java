package com.algorithms.dp;

/*
 * Number of ways to calculate the ways in which we can compose a number with just 1 and 2.
 * E.g - 4 can be written as 1,1,1,1 or 2,2 or 2,1,1 or 1,2,1 or 1,1,2 
 * 
 */
public class AdditionOneTwo {

    
    /**
     * 
     *     num(1) = {1}
     *     num(2) = {1,1
     *               2}
     *     num(3) = {1,1,1
     *               1,2
     *               2,1}
     *     num(4) = {1,1,1,1
     *               1,2,1
     *               2,1,1
     *               2,2
     *               1,1,2}
     *               
     *               So the recurrence relationship is num(n) = num(n-1)+num(n-2)
     * 
     */
    public static int numberOfWays(int num) {
        if(num == 0) return 0;
        if(num == 1) return 1;
        if(num == 2) return 2;
        return numberOfWays(num-1) + numberOfWays(num -2);
    }
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(numberOfWays(6));
    }

}
