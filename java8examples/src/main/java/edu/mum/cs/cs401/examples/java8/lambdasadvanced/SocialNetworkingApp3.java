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
public class SocialNetworkingApp3 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons who are eligible for Selective Service:");

        class CheckPersonEligibleForSelectiveService implements CheckPerson {
            public boolean test(Person p) {
                 return p.getGender() == Person.Gender.MALE
                     && p.getAge() >= 18
                     && p.getAge() <= 25;
             }
         }

         int count = printPersons(roster, new CheckPersonEligibleForSelectiveService());

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
 * Although this approach is less brittle—you don't have to rewrite methods if you change the structure of the Person—you 
 * still have additional code: a new interface and a local class for each search you plan to perform in your application. 
 * Because CheckPersonEligibleForSelectiveService implements an interface, you can use an anonymous class instead of a local class and bypass 
 * the need to declare a new class for each search.
 */



