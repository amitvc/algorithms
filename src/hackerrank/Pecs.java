package hackerrank;

import java.util.ArrayList;
import java.util.List;

public class Pecs {
	
	
	public static class Fruit {
		
	}
	
	public static class Apple extends Fruit {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<? extends Fruit> l = new ArrayList<>();
		
		Fruit f = l.get(0);
		
	}

}
