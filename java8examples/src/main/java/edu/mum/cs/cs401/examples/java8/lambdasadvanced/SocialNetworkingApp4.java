package edu.mum.cs.cs401.examples.java8.lambdasadvanced;

import java.util.List;

import edu.mum.cs.cs401.examples.java8.pojos.Person;
import edu.mum.cs.cs401.examples.java8.utils.PersonUtils;

/**
 * Calls a utility method to perform a particular search
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class SocialNetworkingApp4 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = printPersons(
			    roster,
			    new CheckPerson() {
			        public boolean test(Person p) {
			            return p.getGender() == Person.Gender.MALE
			                && p.getAge() >= 18
			                && p.getAge() <= 25;
			        }
			    }
			);

		System.out.printf("\nThere were %d persons in this category.\n", count);
	}
	
	public static int printPersons(List<Person> roster, CheckPerson tester) {
		int count = 0;
		for (Person p : roster) {
			if (tester.test(p)) {
				p.printPerson();
				++count;
			}
		}
		
		return count;
	}
}


/**
 * This approach reduces the amount of code required because you don't have to create a new class for each search that you want to perform. 
 * However, the syntax of anonymous classes is bulky considering that the CheckPerson interface contains only one method. 
 * In this case, you can use a lambda expression instead of an anonymous class, as described in the next section.
 * 
 */



