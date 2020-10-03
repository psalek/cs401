package lesson7.lecture.overrideequals.instanceofstrategy3;

/** 
 * CORRECT: Person uses instanceof strategy
 * to override equals and subclass PersonWithJob 
 * uses the equals method of Person. With this 
 * approach, PersonWithJob instances can only be
 * compared by name; salary does not count.
 * We prevent overriding equals by declaring it to be final
 *
 */
public class Person {

	protected String name;
	Person(String n) {
		name = n;
	}
	
	//can declare equals to be final to prevent a subclass from overriding
	@Override
	public final boolean equals(Object aPerson) {
		if(aPerson == null) return false; 
		if(!(aPerson instanceof Person)) return false;
		Person p = (Person)aPerson;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new PersonWithJob("Joe", 20000);
		//As Persons, p1 should be equal to p2
		System.out.println("p1.equals(p2)? " + p1.equals(p2));
		System.out.println("p2.equals(p1)? " + p2.equals(p1));
	}

}
