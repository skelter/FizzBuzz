package net.suehs.fizzbuzz;

import java.util.List;

public class FizzBuzz {
    static List<TermMap> traditionalTermMap = 
    	TraditionalTermMap.build(); 
	
	public static String fizzbuzz(int n) {
		for (TermMap termmap : traditionalTermMap) {
			if (n % termmap.n == 0) {
				return termmap.term;
			}
		}
		return "" + n; 
	}
	
	public static void main(String[] args) {
		int max = Integer.parseInt(args[0]);
		System.out.println(fizzbuzz(1,max));
	}
	
	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from 1 to 100.
	 * @return
	 */
	public static String fizzbuzz100() {
		return fizzbuzz(1,100);
	}

	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from min to max inclusively.
	 * @param min minimum integer for fizzbuzz range
	 * @param max maximum integer for fizzbuzz range
	 * @return
	 */
	public static String fizzbuzz(int min, int max) {
		StringBuilder builder = new StringBuilder();
		for (int i=min; i <= max; i++) {
			builder.append(FizzBuzz.fizzbuzz(i));
			builder.append("\n");
		}	
		return builder.toString();
	}

}
