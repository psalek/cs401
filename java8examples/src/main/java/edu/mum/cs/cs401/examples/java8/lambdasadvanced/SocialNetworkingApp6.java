package edu.mum.cs.cs401.examples.java8.lambdasadvanced;

import java.util.List;
import java.util.function.Predicate;

import edu.mum.cs.cs401.examples.java8.pojos.Person;
import edu.mum.cs.cs401.examples.java8.utils.PersonUtils;

/**
 * Calls a utility method to perform a particular search
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class SocialNetworkingApp6 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = printPersonsWithPredicate(
				roster,
			    (Person p) -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25
			);

		System.out.printf("\nThere were %d persons in this category.\n", count);
	}
	
	public static int printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
		int count = 0;
		for (Person p : roster) {
			if (tester.test(p)) {
				++count;
				p.printPerson();
			}
		}

		return count;
	}
}

