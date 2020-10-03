package lesson7.lecture.defaultmethodrules.inherit;

public interface Intface  {
	default void myMethod(int x) {
		System.out.println(x);
	}
}
