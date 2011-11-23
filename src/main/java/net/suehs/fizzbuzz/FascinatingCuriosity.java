package net.suehs.fizzbuzz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Here lies my misguided utility to expand the term map combinations.
 * @author skelter
 *
 */
public class FascinatingCuriosity {
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
		StringBuffer nameBuffer = new StringBuffer();
		int factor = 1;
		for(int i : indices) {
			factor *= terms[i].n;
			nameBuffer.append( terms[i].term);
		}
		return new TermMap(factor, nameBuffer.toString());
	}

}
