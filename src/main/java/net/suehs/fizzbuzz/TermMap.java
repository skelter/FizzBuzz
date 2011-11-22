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
class TermMap implements Comparable<TermMap> {
	final Integer n;
	final String term;

	TermMap(Integer n, String term) {
		assert n != null;
		assert term != null;  // asserts have fallen out of favor in some circles, but I still like them
		this.n = n;
		this.term = term;
	}

	@Override
	public int compareTo(TermMap other) {
		return this.n - other.n;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((n == null) ? 0 : n.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TermMap other = (TermMap) obj;
		if (n == null) {
			if (other.n != null)
				return false;
		} else if (!n.equals(other.n))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TermMap [n=" + n + ", term=" + term + "]";
	}
	


}