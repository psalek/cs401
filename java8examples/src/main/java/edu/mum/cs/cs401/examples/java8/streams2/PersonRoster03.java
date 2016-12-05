package edu.mum.cs.cs401.examples.java8.streams2;

import static java.util.Comparator.*;

import java.util.List;
import java.util.stream.Collectors;

import edu.mum.cs.cs401.examples.java8.pojos.Person;
import edu.mum.cs.cs401.examples.java8.utils.PersonUtils;

/**
 * Pipelines and Streams: Aggregate Operations
 * filter, mapToInt and forEach are all aggregate operations
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class PersonRoster03 {
	
	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);
		
        System.out.println("Sort the roster based on gender, then age:");
        
        List<Person> updatedRoster = roster
        		.stream()
        		.sorted(comparing(Person::getGender).thenComparing(Person::getBirthday))
        		.collect(Collectors.toList());
        
        updatedRoster.forEach(System.out::println);		
	}
	
}
