package lesson3.lecture.inheritance4;

/* A highly-secure version of classB in which
 * input arguments are validated before being used
 */
public class ClassA extends ClassB{
	public void setName(String name) {
		if(name == null || name.trim().equals("")) {
			throw new IllegalArgumentException("Illegal name input");
		}
		super.setName(name);
	}
}
