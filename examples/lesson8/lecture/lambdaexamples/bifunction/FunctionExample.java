package lesson8.lecture.lambdaexamples.bifunction;

import java.util.function.BiFunction;

public class FunctionExample {
	/* As a lambda:
	 * public static void main(String[] args) { BiFunction<Integer, Integer,
	 * Integer> f = (x,y) -> 2*x - y; System.out.println(f.apply(2, 3)); }
	 */
	public static void main(String[] args) {
		class MyBiFunction implements BiFunction<Integer, Integer, Integer> {
			public Integer apply(Integer x, Integer y) {
				return 2 * x.intValue() - y.intValue();
			}
		}
		MyBiFunction f = new MyBiFunction();
		System.out.println(f.apply(2, 3)); // output 1
	}

}
