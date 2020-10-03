package lesson7.lecture.overrideequals.instanceofstrategy;

/** 
 * CORRECT: Use instanceof strategy for equals and prevent
 * classes from subclassing, to avoid asymmetric equals.
 */
final public class Person {

		private String name;
		Person(String n) {
			name = n;
		}
		@Override
		public boolean equals(Object aPerson) {
			if(aPerson == null) return false; 
			if(!(aPerson instanceof Person)) return false;
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
