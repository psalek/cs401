package lesson3.lecture.orderofexec;

public class SubClassE extends ClassE {
	static int subInt = subIntMethod();
	static int subIntMethod(){
		System.out.println("3-Initializing subclass static variable subInt");
		return 2;
	}
	
	static {
		System.out.println("4-Executing subclass static block");
	}

	
	static int subInstanceIntMethod() {
		System.out.println("9-Initialzing subclass instance variable subInstanceInt");
		return 3;
	}
	
	//constructor
	SubClassE(){
		System.out.println("10-Running subclass constructor");
	}
	
	
	
	{
		System.out.println("8-Running subclass object initialization block");
	}
	
	
	@SuppressWarnings("unused")
	private int subInstanceInt = subInstanceIntMethod();
		
}

