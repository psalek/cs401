package lesson7.lecture.overrideequals.equalclassesstrategy1;

/** 
 *  CORRECT:
 *  If equal-classes strategy is used, make the class final 
 */
final public class Person {

	private String name;
	Person(String n) {
		name = n;
	}
	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(aPerson.getClass() != this.getClass()) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
	}

}
