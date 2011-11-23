package net.suehs.fizzbuzz;

import java.util.ArrayList;
import java.util.List;

public class TermUtil {
	/**
	 * Utility to ease throwing together literal term maps.
	 * 
	 * @param args
	 * @return
	 */
	static List<TermMap> buildTermMap(Object... args) {
		int terms = args.length / 2;
		List<TermMap> list = new ArrayList<TermMap>();
		for (int i=0; i < terms; i++) {
			list.add(new TermMap((Integer)args[i*2], (String) args[(i*2)+1]));
		}
		return list;
	}
}
