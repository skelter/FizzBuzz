package net.suehs.fizzbuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class FizzBuzz {
    static List<TermMap> traditionalTermMap = 
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
//		List<TermMap> multipleMap = expandMap(map);
//		Collections.sort(multipleMap);
//		Collections.reverse(multipleMap);
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

	/**
	 * Expand the given list of terms to a list of their combinations.
	 * @param givenMap
	 * @return
	 */
	public static List<TermMap> expandMap(List<TermMap> givenMap) {
		// This sure seems like a combinatorial.  Is there a library?
		
		// Sort the list and ensure elements are unique
		SortedSet<TermMap> set = new TreeSet<TermMap>(givenMap);
		TermMap[] setarray =  set.toArray(new TermMap[] {});
		
		int maxComboSize = set.size();
		
		// sliding a window across does not get all the combinations. 
		// I sure am missing clojure and persistent immutable data structures here.
		// Some nooding, and I think simple integer combinations give me the necessary indices.
		// When I did this as a sliding window (which was wrong) it looked like it might be O(n^n). We should test performance.
		ArrayList<TermMap> expandedMap = new ArrayList<TermMap>();
		for(Integer[] indices : combinations(maxComboSize)) {
				expandedMap.add(combineTerms(setarray,indices));
		}
		
		Collections.sort(expandedMap);
		return expandedMap;
	}

	// ended up doing some math reading and revisiting discrete math.
	// thanks for that.
	// what I am looking for is a powerset
	private static List<Integer[]> combinations(int maxComboSize) {
		List<Integer[]> powerset = new ArrayList<Integer[]>();
		int setSize = (int) Math.pow(2, maxComboSize) - 1;
		for(int i=0; i < setSize; i++) {
			powerset.add(powerSetIndices(i+1));
		}
		return powerset;
	}
	
	/**
	 * The indexes for a given row in the powerset.
	 * @param n
	 * @return
	 * 
	 */
	static Integer[] powerSetIndices(int n) {
		List<Integer> list = new ArrayList<Integer>(); 
		int bit = 1;
	  	while (n > 0) {
	  		if ((n & 1) > 0) {
	  			list.add(bit-1);
	  		}
	  	  bit++;
	  	  n = n >> 1;	
	  	}
	  	Integer[] result = new Integer[list.size()];
	  	for(int i =0 ; i < result.length; i++ ) {
	  		result[i] = list.get(i);
	  	}
	  	return result;
	}

	private static TermMap combineTerms(TermMap[] terms, Integer[] indices) {
		String name = "";
		int factor = 1;
		for(int i : indices) {
			factor *= terms[i].n;
			name += terms[i].term;
		}
		return new TermMap(factor, name);
	}

}
