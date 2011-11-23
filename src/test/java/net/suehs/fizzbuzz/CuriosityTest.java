package net.suehs.fizzbuzz;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class CuriosityTest {
	@Test
	public void multiplyMapTest() {
		List<TermMap> givenMap = TermUtil.buildTermMap(
				3, "fizz",
				5, "buzz",
				8, "sprite");
		List<TermMap> expected = TermUtil.buildTermMap( 
				3, "fizz",
				5, "buzz",
				8, "sprite",
				15, "fizzbuzz",
				24, "fizzsprite",
				40, "buzzsprite",
				120, "fizzbuzzsprite");
				
		assertEquals(expected.toArray(), FascinatingCuriosity.expandMap(givenMap).toArray());
	}
	
	/**
	 * cba
	 * 
	 * 1   a   0
	 * 2   b   1
	 * 3  ba   0,1
	 * 4   c   2
	 * 5  ca   2,0
	 * 6  cb   2,1
	 * 7 cba   2,1,0
	 */
	@Test
	public void testPowersetIndexGenerator() {
	    
		assertEquals(new Integer[] {0}, FascinatingCuriosity.powerSetIndices(1));
		assertEquals(new Integer[] {1}, FascinatingCuriosity.powerSetIndices(2)); 
		assertEquals(new Integer[] {0,1}, FascinatingCuriosity.powerSetIndices(3));
		assertEquals(new Integer[] {2}, FascinatingCuriosity.powerSetIndices(4)); 
		assertEquals(new Integer[] {0,2}, FascinatingCuriosity.powerSetIndices(5));
		assertEquals(new Integer[] {1,2}, FascinatingCuriosity.powerSetIndices(6)); 
		assertEquals(new Integer[] {0,1,2}, FascinatingCuriosity.powerSetIndices(7)); 
	}
}
