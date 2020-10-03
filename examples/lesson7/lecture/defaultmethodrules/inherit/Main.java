package lesson7.lecture.defaultmethodrules.inherit;

public class Main {

	public static void main(String[] args) {
		//this shows how a default method is inherited
		(new Impl()).myMethod(3);
		
		//this shows how default method is inherited by
		//a subinterface
		(new SubImpl()).myMethod(3);
		
	    

	}

}
