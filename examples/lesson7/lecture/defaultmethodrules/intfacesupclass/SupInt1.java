package lesson7.lecture.defaultmethodrules.intfacesupclass;

public interface SupInt1 {
	default void myMethod(int x) {
		myMethod(x + x);
	}
}
