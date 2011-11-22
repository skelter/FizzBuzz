package net.suehs.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

/**
 * TraditionalTermMap is the traditional fizzbuzz term map, mapping
 * 3 to fizz, 5 to buzz and 15 to fizzbuzz.
 * 
 * @author skelter
 *
 */
class TraditionalTermMap {
	static List<TermMap> build() {
		List<TermMap> mappings = new ArrayList<TermMap>();
		mappings.add(new TermMap(15,"fizzbuzz"));
		mappings.add(new TermMap(5, "buzz"));
		mappings.add(new TermMap(3, "fizz"));
		return mappings;
	}
}
