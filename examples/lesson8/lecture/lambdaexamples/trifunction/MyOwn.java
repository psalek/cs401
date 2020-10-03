package lesson8.lecture.lambdaexamples.trifunction;

public class MyOwn {
	public static void main(String[] args) {
		TriFunction<Integer, Integer, Integer, Integer> f =
				(x,y, z) -> x + y + z;
		System.out.println(f.apply(2, 3, 4));
		
		TriFunction<String, String, String, String> g =
				(x,y, z) -> x + " " + y + " "+ z;
		System.out.println(g.apply("hello", "bob,", "how are you?"));
		
	}
}
