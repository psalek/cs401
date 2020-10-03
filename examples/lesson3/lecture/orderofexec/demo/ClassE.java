package lesson3.lecture.orderofexec.demo;

public class ClassE {

	static int superInt = superIntMethod();
	static int superIntMethod(){
		return 1;
	}
	static {
		System.out.println("static block");
	}
	
	static int superInstanceIntMethod() {
		return 3;
	}
	
	@SuppressWarnings("unused")
	private int superInstanceInt=superInstanceIntMethod();
	
	//constructor
	ClassE(){
		System.out.println("superclass constructor");
	}
	
	{
		System.out.println("object initialization block");
	}
	

}

