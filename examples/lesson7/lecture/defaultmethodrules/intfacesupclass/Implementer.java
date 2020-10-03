package lesson7.lecture.defaultmethodrules.intfacesupclass;

public class Implementer extends SupClass implements SupInt1 {
	//myMethod doesn't need to be overridden
	//SupClass wins
	public static void main(String[] args) {
		Implementer i = new Implementer();
		i.myMethod(3);
	}
}
