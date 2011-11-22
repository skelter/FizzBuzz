
public class FizzBuzz {

	public String fizzbuzz(int n) {
		if (n % 5 == 0 && n % 3 == 0) {
			return "fizzbuzz";
		}
		if (n % 5 == 0) {
			return "buzz";
		}
		if (n % 3 == 0) {
			return "fizz";
		}
		return "" + n; 
	}
	
	public static void main(String[] args) {
		//System.out.println(fizzbuzz100());
		System.out.println(fizzbuzz(1,500));
	}
	
	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from 1 to 100.
	 * @return
	 */
	public static String fizzbuzz100() {
		return fizzbuzz(1,100);
	}

	/**
	 * Returns a string consisting of integers or fizzbuzz interpretation from min to max inclusively.
	 * @param min minimum integer for fizzbuzz range
	 * @param max maximum integer for fizzbuzz range
	 * @return
	 */
	public static String fizzbuzz(int min, int max) {
		StringBuilder builder = new StringBuilder();
		FizzBuzz fb = new FizzBuzz();
		for (int i=min; i <= max; i++) {
			builder.append(fb.fizzbuzz(i));
			builder.append("\n");
		}	
		return builder.toString();
	}

}
