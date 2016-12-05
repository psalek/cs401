package edu.mum.cs.cs401.examples.java8.lambdasadvanced;

import java.util.List;
import java.util.function.Consumer;
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
public class SocialNetworkingApp7 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

		int count = processPersons(
				roster,
			    (Person p) -> p.getGender() == Person.Gender.MALE && p.getAge() >= 18 && p.getAge() <= 25,
			    p -> p.printPerson()
			);

		System.out.printf("\nThere were %d persons in this category.\n", count);
	}

	public static int processPersons(List<Person> roster,
			Predicate<Person> tester, Consumer<Person> block) {
		int count = 0;
		for (Person p : roster) {
			if (tester.test(p)) {
				++count;
				block.accept(p);
			}
		}
		return count;
	}
}

