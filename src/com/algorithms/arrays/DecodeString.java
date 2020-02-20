package com.algorithms.arrays;

import java.util.Stack;

public class DecodeString {
	
	public static int pos =0;
	public static String decodeStringRec(String s) {
        return helper(s);
    }
    
    public static String helper( String s) {
        int num=0;
        String word = "";
        for(;pos<s.length(); pos++) {
            char cur = s.charAt(pos);
            if(cur == '[') {
            	++pos;
                String curStr = helper(s);
                for(;num>0;num--) word += curStr;
            } else if (cur >= '0' && cur <='9') {
                num = num*10 + cur - '0';
            } else if (cur == ']') {
                return word;
            } else {    // Normal characters
                word += cur;
            }
        }
        return word;
    }
	
	public static String decodeString(String s) {
		Stack<Integer> count = new Stack<>();
        Stack<String> result = new Stack<>();
        int i = 0;
        result.push("");
        while (i < s.length()) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                int start = i;
                while (s.charAt(i + 1) >= '0' && s.charAt(i + 1) <= '9') i++;
                count.push(Integer.parseInt(s.substring(start, i + 1)));
            } else if (ch == '[') {
                result.push("");
            } else if (ch == ']') {
                String str = result.pop();
                StringBuilder sb = new StringBuilder();
                int times = count.pop();
                for (int j = 0; j < times; j += 1) {
                    sb.append(str);
                }
                result.push(result.pop() + sb.toString());
            } else {
                result.push(result.pop() + ch);
            }
            i += 1;
        }
        return result.pop();
	}
	
	
	public static void decode(String str) {
		 Stack<Integer> integerstack = new Stack<>();
	        Stack<Character> stringstack = new Stack<>();
	        String temp = "", result = "";
		 // Traversing the string
        for (int i = 0; i < str.length(); i++)
        {
            int count = 0;
      
            // If number, convert it into number
            // and push it into integerstack.
            if (Character.isDigit(str.charAt(i)))
            {
                while (Character.isDigit(str.charAt(i)))
                {
                    count = count * 10 + str.charAt(i) - '0';
                    i++;
                }
      
                i--;
                integerstack.push(count);
            }
      
            // If closing bracket ']', pop elemment until
            // '[' opening bracket is not found in the
            // character stack.
            else if (str.charAt(i) == ']')
            {
                temp = "";
                count = 0;
      
                if (!integerstack.isEmpty())
                {
                    count = integerstack.peek();
                    integerstack.pop();
                }
      
                while (!stringstack.isEmpty() && stringstack.peek()!='[' )
                {
                    temp = stringstack.peek() + temp;
                    stringstack.pop();
                }
      
                if (!stringstack.empty() && stringstack.peek() == '[')
                    stringstack.pop();
      
                // Repeating the popped string 'temo' count
                // number of times.
                for (int j = 0; j < count; j++)
                    result = result + temp;
      
                // Push it in the character stack.
                for (int j = 0; j < result.length(); j++)
                    stringstack.push(result.charAt(j));
      
                result = "";
            }
      
            // If '[' opening bracket, push it into character stack.
            else if (str.charAt(i) == '[')
            {
                if (Character.isDigit(str.charAt(i-1)))
                    stringstack.push(str.charAt(i));
      
                else
                {
                    stringstack.push(str.charAt(i));
                    integerstack.push(1);
                }
            }
      
            else
                stringstack.push(str.charAt(i));
        }
      
        // Pop all the elmenet, make a string and return.
        while (!stringstack.isEmpty())
        {
            result = stringstack.peek() + result;
            stringstack.pop();
        }
        System.out.println(result);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeString ds = new DecodeString();
		String s;
		System.out.println(ds.decodeString("37[a2[bc]]"));
		System.out.println(decodeStringRec("3[a2[bc]]"));
		decode("3[a2[bc]]");
		decode("3[b]2[ca]");

	}

}
