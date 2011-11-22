package net.suehs.fizzbuzz;

import static org.junit.Assert.*;
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
	
}
