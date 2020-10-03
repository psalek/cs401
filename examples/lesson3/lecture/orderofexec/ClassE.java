package lesson3.lecture.orderofexec;

public class ClassE {

	static int superInt = superIntMethod();
	static int superIntMethod(){
		System.out.println("1-Initializing superclass static variable superInt");
		return 1;
	}
	static {
		System.out.println("2-Executing superclass static block");
	}
	
	static int superInstanceIntMethod() {
		System.out.println("5-Initialzing superclass instance variable superInstanceInt");
		return 3;
	}
	
	@SuppressWarnings("unused")
	private int superInstanceInt=superInstanceIntMethod();
	
	//constructor
	ClassE(){
		System.out.println("7-Running superclass constructor");
	}
	
	{
		System.out.println("6-Running superclass object initialization block");
	}
	

}

