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
public class SocialNetworkingApp5 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = printPersons(
				roster,
			    (Person p) -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25
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
 * You can use a standard functional interface in place of the interface CheckPerson, which reduces even further the amount of code required.
 * 
 */



