package net.suehs.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * TraditionalTermMap is the traditional fizzbuzz term map, mapping
 * 3 to fizz, 5 to buzz.  The algorithm should also print fizzbuz for multiples of 15, but this map does not contain that combination.
 * 
 * @author skelter
 *
 */
class TraditionalTermMap {
	static List<TermMap> build() {
		List<TermMap> mappings = new ArrayList<TermMap>();
		mappings.add(new TermMap(3, "fizz"));
		mappings.add(new TermMap(5, "buzz"));
		return mappings;
	}
}
