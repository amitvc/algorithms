package hackerrank;

import java.util.*;

public class Enumeration {
	
	private static Map<Character, String> lookup = new HashMap<>();
    static {
      lookup.put('1',"");
      lookup.put('2', "abc");
      lookup.put('3',"def");
      lookup.put('4',"ghi");
      lookup.put('5',"jkl");
      lookup.put('6',"mno");
      lookup.put('7',"pqrs");
      lookup.put('8',"tuv");
      lookup.put('9',"wxyz");
      lookup.put('0',"");
    }
  
  
    public static void enumerate(String soFar, List<String> values) {
        if(soFar.isEmpty()) {
           return;
        } else {
          char firstChar = soFar.charAt(soFar.length()-1);
          String code = lookup.get(firstChar);
          if(values.size() == 0) {
          	for(int i=0; i < code.length(); i++) {
            	char c = code.charAt(i);
            	values.add(""+c);
          	}  
          } else {
            List<String> latest = new ArrayList<>();
            for(int i=0; i < code.length(); i++) {
            	char c = code.charAt(i);
            	for(String s : values) {
                  latest.add(""+c+s);
                }
          	} 
            values.clear();
            values.addAll(latest);
          }
          
          enumerate(soFar.substring(0, soFar.length()-1), values);
        }
    }
    
    
  
	// Return a string array that contains all the possible strings
	public static String[] keypad(int n){
		// Write your code here
       String number = new String(""+n);
       List<String> results = new ArrayList<>();
       enumerate(number, results);
       String enumeration[] = new String[results.size()];
       int i=0; 
       for(String s : results) {
          enumeration[i++] = s;
       }
      return enumeration;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] s = keypad(234);
		System.out.println(s);

	}

}
