package net.suehs.fizzbuzz;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.Test;



public class FizzBuzzTest {

	/** Numbers 1-100,  if divisible by 3 print fizz, if evenly divisible by 5 print buzz, and if evenly divisible by both, print fizzbuz.  
	 * 
	 */
	   // "3" => fizz
	   // "2" => "2"
	   // "5" => "buzz"
	   // "15" => "fizzbuzz"
	   // "30" => "fizzbuzz"
	   // "10" => "buzz"
	   // "6"  => "fizz"
	
	
	@Test 
	public void printsNumbersForNonInterestingNumbers() {
		assertEquals("2", FizzBuzz.fizzbuzz(2));
		assertEquals("4", FizzBuzz.fizzbuzz(4));
		
	}
	
	@Test
	public void printsFizzForMultiplesOf3() {
		assertEquals("fizz", FizzBuzz.fizzbuzz(3));
		assertEquals("fizz", FizzBuzz.fizzbuzz(6));
	}
	
	@Test
	public void printsBuzzForMultiplesOf5() {
	
		assertEquals("buzz", FizzBuzz.fizzbuzz(5));
		assertEquals("buzz", FizzBuzz.fizzbuzz(10));
	}
	
	@Test
	public void printsFizzBuzzForMultiplesOf15() {
		assertEquals("fizzbuzz", FizzBuzz.fizzbuzz(15));
		assertEquals("fizzbuzz", FizzBuzz.fizzbuzz(30));
	}
	
	@Test 
	public void standardFizzBuzTo30() {
		//TODO: This is starting to look fragile
		assertEquals("1\n2\nfizz\n4\nbuzz\nfizz\n7\n8\nfizz\nbuzz\n11\nfizz\n13\n14\nfizzbuzz\n",FizzBuzz.fizzbuzz(1,15));
	}
	
	@Test
	public void spriteBuzUpThrough40acceptance() {
		String expected_sprite_results = read("spritedat.txt");
		List<TermMap> spritemap = buildSpriteMap(
				3,"fizz",
				5,"buzz",
				8,"sprite");
		assertEquals(expected_sprite_results,FizzBuzz.fizzbuzz(spritemap, 1, 45));
	}

	/**
	 * Utility function to read the file in to a string, or fail test.
	 * @param string
	 * @return
	 */
	private String read(String string) {
		try {
			return FileUtils.readFileToString(new File("src/test/java/net/suehs/fizzbuzz/spritedat.txt"));
		} catch (IOException e) {
			e.printStackTrace();
			fail(e.toString());
		}
		return "";
	}

	/**
	 * Utility to ease throwing together literal term maps.
	 * 
	 * @param args
	 * @return
	 */
	private List<TermMap> buildSpriteMap(Object... args) {
		int terms = args.length / 2;
		List<TermMap> list = new ArrayList<TermMap>();
		for (int i=0; i < terms; i++) {
			list.add(new TermMap((Integer)args[i*2], (String) args[(i*2)+1]));
		}
		return list;
	}
	
	@Test
	public void multiplyMapTest() {
		List<TermMap> givenMap = buildSpriteMap(
				3, "fizz",
				5, "buzz",
				8, "sprite");
		List<TermMap> expected = buildSpriteMap( 
				3, "fizz",
				5, "buzz",
				8, "sprite",
				15, "fizzbuzz",
				24, "fizzsprite",
				40, "buzzsprite",
				120, "fizzbuzzsprite");
				
		assertEquals(expected.toArray(), FizzBuzz.expandMap(givenMap).toArray());
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
	    
		assertEquals(new Integer[] {0}, FizzBuzz.powerSetIndices(1));
		assertEquals(new Integer[] {1}, FizzBuzz.powerSetIndices(2)); 
		assertEquals(new Integer[] {0,1}, FizzBuzz.powerSetIndices(3));
		assertEquals(new Integer[] {2}, FizzBuzz.powerSetIndices(4)); 
		assertEquals(new Integer[] {0,2}, FizzBuzz.powerSetIndices(5));
		assertEquals(new Integer[] {1,2}, FizzBuzz.powerSetIndices(6)); 
		assertEquals(new Integer[] {0,1,2}, FizzBuzz.powerSetIndices(7)); 
	}
}
