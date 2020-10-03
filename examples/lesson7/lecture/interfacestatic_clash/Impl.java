package lesson7.lecture.interfacestatic_clash;

public class Impl implements Sup1, Sup2 {
	
	public static void main(String[] args) {
		Sup1 s = new Impl();
		int val = Sup1.myMethod();
		System.out.println(val);
	}
	
	public static int myMethod() {
		return 4;
	}
}
