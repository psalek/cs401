package lesson7.lecture.reviewofinner.staticnested;

public class MyClass {
	private String s = "hello";
	public static void main(String[] args) {
		new MyClass();
	}
	MyClass() {
		// access static methods in the usual way
		MyStaticNestedClass.myStaticMethod();
		// access instance methods in the usual way too
		// except that now private methods are also accessible
		MyStaticNestedClass cl = new MyStaticNestedClass();
		cl.myOtherMethod();
		// as with inner classes, private instance vbles are accessible
		int y = cl.x;
	}
	static class MyStaticNestedClass {
		private int x = 0;
		static void myStaticMethod() {
//			 String t = s; // compiler error -- no access
		}
		private void myOtherMethod() {
		}
	}
}
