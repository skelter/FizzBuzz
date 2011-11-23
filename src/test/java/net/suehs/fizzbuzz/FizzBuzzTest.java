package net.suehs.fizzbuzz;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
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
	public void standardFizzBuzTo15() {
		//TODO: This is starting to look fragile
		assertEquals("1\n2\nfizz\n4\nbuzz\nfizz\n7\n8\nfizz\nbuzz\n11\nfizz\n13\n14\nfizzbuzz\n",FizzBuzz.fizzbuzz(1,15));
	}
	
	@Test
	public void spriteBuzUpThrough40acceptance() {
		String expected_sprite_results = read("spritedat.txt");
		List<TermMap> spritemap = TermUtil.buildTermMap(
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


	

}
