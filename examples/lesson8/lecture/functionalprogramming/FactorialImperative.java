package lesson8.lecture.functionalprogramming;

public class FactorialImperative {
	/** Assumes n is a positive integer */
	public static int factorial(int n) {
		int accum = 1;
		for(int i = 1; i <= n; ++i) {
			accum *= i;
		}
		return accum;
	}
	
	public static void main(String[] args) {
		int input = 8;
		int output = factorial(input);
		System.out.printf("factorial(%d) = %d", input, output);
	}
}
