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
public class SocialNetworkingApp2 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);

        System.out.println("Persons between the ages of 14 and 30:");
        
        int count = printPersonsWithinAgeRange(roster, 14, 30);
        
		System.out.printf("\nThere were %d persons in this category.\n", count);
	}

	public static int printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
		int count = 0;
		for (Person p : roster) {
			if (low <= p.getAge() && p.getAge() < high) {
				++count;
				p.printPerson();
			}
		}
		
		return count; 
	}
}


/**
 * What if you want to print members of a specified sex, or a combination of a specified gender and age range? 
 * What if you decide to change the Person class and add other attributes such as relationship status or geographical location? 
 * Although this method is more generic than printPersonsOlderThan, trying to create a separate method for each possible search query 
 * can still lead to brittle code. You can instead separate the code that specifies the criteria for which you want to search in a different class.
 */



