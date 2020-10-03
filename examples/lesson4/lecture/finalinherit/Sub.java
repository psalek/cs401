package lesson4.lecture.finalinherit;

//Shows how compiler locates first ancestor
//in inheritance chain in which the final method
//is implemented
public class Sub extends Super {
	public static void main(String[] args) {
		Super s = new Sub();
		s.print();
	}
	
	/* no possibility of an implementation of print here*/
//	void print() {
//	   System.out.println("cannot do this");
//	}
	
}
