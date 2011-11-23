package net.suehs.fizzbuzz;

import java.util.List;

public class FizzBuzz {
    final static List<TermMap> traditionalTermMap = 
    	TraditionalTermMap.build(); 
	
    public static String fizzbuzz(int n) {
    	return fizzbuzz(traditionalTermMap, n);
    }
    
	public static String fizzbuzz(List<TermMap> map, int n) {
		StringBuffer buff = new StringBuffer();
		for (TermMap termmap : map) {
			if (n % termmap.n == 0) {
				buff.append( termmap.term);
			}
		}
		if (buff.length() > 0) {
			return buff.toString();
		}
		return "" + n;
	}
	
	public static void main(String[] args) {
		int max = 500;
		if (args.length > 0) {
			max = Integer.parseInt(args[0]);
		}
		System.out.println(fizzbuzz(traditionalTermMap,1,max));
	}
	
	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from 1 to 100.
	 * @return
	 */
	public static String fizzbuzz100() {
		return fizzbuzz(traditionalTermMap, 1,100);
	}

	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from min to max inclusively.
	 * @param min minimum integer for fizzbuzz range
	 * @param max maximum integer for fizzbuzz range
	 * @return
	 */
	public static String fizzbuzz(List<TermMap> map, int min, int max) {
		StringBuilder builder = new StringBuilder();
		for (int i=min; i <= max; i++) {
			builder.append(FizzBuzz.fizzbuzz(map,i));
			builder.append("\n");
		}	
		return builder.toString();
	}

	public static String fizzbuzz( int min, int max) {
		return fizzbuzz(traditionalTermMap, min, max);
	}


}
