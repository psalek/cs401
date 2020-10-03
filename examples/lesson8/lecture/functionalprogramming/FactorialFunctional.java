package lesson8.lecture.functionalprogramming;

public class FactorialFunctional {
	/** Assumes n is a non-negative integer */
	public static int factorial(int n) {
		return (n==0 || n==1) ? 1 : n * factorial(decrement(n));
	}
	
	private static int decrement(int n) {
		return n - 1;
	}
	
	
	public static void main(String[] args) {
		int input = 5;
		int output = factorial(input);
		System.out.printf("factorial(%d) = %d", input, output);
	}
	
	
}
