package com.algorithms.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



/*(x,y) to
 * (x+1, y), 
(x - 1, y),             x+1,y    x,y-1   x,y-1      x,y-1       x,y-1       x,y-1        x,y-1
(x, y+1),     0,1 -- >  1,1   -- 1,0 --  1,-1    -- 1,-2     -- 1, -3 --    1,-4     --    1,-5
(x, y-1),     0,1 -- > 3,2
(x-1, y-1), 
(x+1,y+1), 
(x-1,y+1), 
(x+1,y-1) */

//3 0 1 2 
//3 1 -5 0
 // ans is 3.


//
//3 0 -4 1
//3 1 2 1

// (0,1) --> (-4,2) 1+3 = 4 
// (-4,2) --> (1,1) 1+1+1+1+1=5 
public class InfiniteGrid {

	 // X and Y co-ordinates of the points in order.
    // Each point is represented by (X.get(i), Y.get(i))
    public static int coverPoints(List<Integer> X, List<Integer> Y) {
        int step = 0;
        int j = 0;
        int len = X.size();
        
        for(Integer x : X) {
        	if(j < len-1) {
        		int y = Y.get(j);
            	System.out.println("X = "+x+" Y = "+y);
            	int x1 = X.get(j+1);
            	int y1 = Y.get(j+1);
            	
            	step += Math.abs(x1-x) > Math.abs(y1-y) ? Math.abs(x1-x) : Math.abs(y1-y);
            	
            	j++;
        	}
        	
        }
    	
        return step;
    }

	public static void main(String[] args) {
		Integer x[] = {-7,-13};
		Integer y[] = {1,-5};
		List<Integer> X = Arrays.asList(x);
		List<Integer> Y = Arrays.asList(y);
		System.out.println(coverPoints(X, Y));
	}

}
