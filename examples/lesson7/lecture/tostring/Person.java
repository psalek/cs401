package lesson7.lecture.tostring;

/** 
 * Illustrates default behavior of the toString method.
 *
 */
public class Person {
	@SuppressWarnings("unused")
	private String name;
	Person(String n) {
		name = n;
	}
	
	public static void main(String[] args) {
		Person p = new Person("Joe");
		//output is class name followed by p.hashCode()
		System.out.println(p); 
		System.out.println(Integer.toHexString(p.hashCode()));
	}
}
