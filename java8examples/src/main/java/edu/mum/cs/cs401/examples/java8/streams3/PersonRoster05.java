package edu.mum.cs.cs401.examples.java8.streams3;

import java.util.List;

import edu.mum.cs.cs401.examples.java8.pojos.Person;
import edu.mum.cs.cs401.examples.java8.utils.PersonUtils;
import edu.mum.cs.cs401.examples.java8.utils.Timer;

/**
 * Pipelines and Streams: Reduction average() is a reduction operation
 * 
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class PersonRoster05 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100000);

		long count = 0;
		Timer.start();
		for (int i = 0; i < 100; ++i) {
			count = roster
					.stream()
					.filter(p -> p.getGender() == Person.Gender.MALE && p.getAge() < 25)
					.count();
		}
		Timer.stop();
		System.out.printf("Took %d milliseconds to count %d persons\n", Timer.getDuration(), count);

		Timer.start();
		for (int i = 0; i < 100; ++i) {
			count = roster
					.stream()
					.filter(p -> p.getGender() == Person.Gender.MALE)
					.filter(p -> p.getAge() < 25)
					.count();
		}
		Timer.stop();
		System.out.printf("Took %d milliseconds to count %d persons\n", Timer.getDuration(), count);
	}

}
