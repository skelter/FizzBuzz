import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class FirstTest {

	private FizzBuz fb;

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
	
	@Before
	public void setUp() {
	  fb = new FizzBuz();	
	}
	
	@Test 
	public void printsNumbersForNonInterestingNumbers() {
		assertEquals("2", fb.fizzbuzz(2));
		assertEquals("4", fb.fizzbuzz(4));
		
	}
	
	@Test
	public void printsFizzForMultiplesOf3() {
		assertEquals("fizz", fb.fizzbuzz(3));
		assertEquals("fizz", fb.fizzbuzz(6));
	}
	
	@Test
	public void printsBuzzForMultiplesOf5() {
	
		assertEquals("buzz", fb.fizzbuzz(5));
		assertEquals("buzz", fb.fizzbuzz(10));
	}
	
	@Test
	public void printsFizzBuzzForMultiplesOf15() {
		assertEquals("fizzbuzz", fb.fizzbuzz(15));
		assertEquals("fizzbuzz", fb.fizzbuzz(30));
	}
	
}
