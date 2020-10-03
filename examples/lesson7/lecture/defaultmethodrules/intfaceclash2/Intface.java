package lesson7.lecture.defaultmethodrules.intfaceclash2;

public interface Intface extends SupInt1, SupInt2 {
	//clash must be resolved, either by making myMethod abstract
	//as is done here, or by overriding it in a new default method
	void myMethod(int x);
}
