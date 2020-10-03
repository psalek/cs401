package lesson7.lecture.defaultmethodrules.intfaceclash2;

public class Implementer implements SupInt1, SupInt2 {
	//clash must be resolved, either by making myMethod abstract
	//or by overriding it as is done here
   public void myMethod(int x) {
	   if(x > 0) {
		   for(int i = 0; i < x; ++i) {
			   System.out.println("hello");
		   }
	   } else {
		   System.out.println("goodbye");
	   }
   }
}
