package edu.mum.cs.cs401.examples.java8.streams3;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import edu.mum.cs.cs401.examples.java8.pojos.Employee;
import edu.mum.cs.cs401.examples.java8.pojos.Person;
import edu.mum.cs.cs401.examples.java8.pojos.Person.Gender;
import edu.mum.cs.cs401.examples.java8.utils.PersonUtils;

/**
 * Pipelines and Streams: Aggregate Operations
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class PersonRoster01 {

	public static void main(String[] args) {
		List<Person> roster = PersonUtils.generateRandomPersonList(100);
		
		Employee e = new Employee(null, null);
		roster.add(e);

		Function<Person, Gender> function = 
				p -> {
					if(p.getGender() == Gender.MALE) {
						return Gender.MALE;
					}
					else {
						return null;
					}
				};
		System.out.println("List of genders in the roster:" + mapList(roster, function));

	}
	
	public static List<Gender> mapList(List<Person> list, Function<Person, Gender> function) {
		return list.stream().map(function).collect(Collectors.toList());
	}


}
