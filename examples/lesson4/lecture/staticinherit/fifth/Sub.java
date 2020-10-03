package lesson4.lecture.staticinherit.fifth;

//Shows why compiler is able to bind static methods 
//It finds the first ancestor in the inheritance
//hierarchy that has an implementation of the called
//static method and binds the method to that one.
public class Sub extends Super {
	public static void main(String[] args) {
		tryit();
	}
	
}
