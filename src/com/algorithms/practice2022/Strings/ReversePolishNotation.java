package com.algorithms.practice2022.Strings;

import java.util.Stack;
import java.util.concurrent.Executors;

public class ReversePolishNotation {

    public static int evaluate(char input[]) {
        if (input.length == 0)
            return 0;

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < input.length) {
            char c = input[i++];
            if (Character.isDigit(c)) {
                stack.push(Integer.parseInt(""+c));
            } else {
                if (stack.size() < 2) {
                    throw new RuntimeException("Some problem with the notation");
                }
                int rop = stack.pop();
                int lop = stack.pop();
                int result = 0;
                switch (c) {
                    case '+':
                        result = lop + rop;
                        break;
                    case '-':
                        result = lop - rop;
                        break;
                    case '*':
                        result = lop * rop;
                        break;
                    case '/':
                        result = lop / rop;
                        break;
                    default:
                        throw new RuntimeException("Operand should be either +,-,*,/");
                }
                stack.push(result);
            }
        }
        return stack.pop();
    }


    public static void main(String[] args) {
        char input[] = {'1', '2', '3', '+', '2', '*', '-'};
        System.out.println("Output " + evaluate(input));
    }
}
