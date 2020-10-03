package lesson7.lecture.overrideequals.equalclassesstrategy2;

/** 
 * INCORRECT: Person and PersonWithJob use equal-classes strategy
 * to override equals separately. Bad: Two Persons with same name
 * are not seen as equal.
 *
 */
public class Person {

	protected String name;
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
		Person p2 = new PersonWithJob("Joe", 20000);
		//Prints false to console in each case
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}
}
