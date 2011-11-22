package net.suehs.fizzbuzz;

/**
 * A TermMap is an instance of a mapping of a term or "divisor" to a name.
 * 3 to "fizz", 5 to "buzz", etc.
 * 
 * The break from traditional encapsulation here is done conscientiously, 
 * as the class is written to be immutable, and access shouldn't cause any
 * events.  Traditionalists would wrap the fields in getters.  
 * 
 * @author skelter
 *
 */
class TermMap {
	final Integer n;
	final String term;

	TermMap(Integer n, String term) {
		assert n != null;
		assert term != null;  // asserts have fallen out of favor in some circles, but I still like them
		this.n = n;
		this.term = term;
	}
}