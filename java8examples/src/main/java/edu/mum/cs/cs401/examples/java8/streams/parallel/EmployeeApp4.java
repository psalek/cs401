package edu.mum.cs.cs401.examples.java8.streams.parallel;

import java.util.Collection;

import edu.mum.cs.cs401.examples.java8.pojos.Employee;
import edu.mum.cs.cs401.examples.java8.utils.EmployeeUtils;

/**
 * Using Stream API to average over a collection of items
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class EmployeeApp4 {
	
	private static final int COLLECTION_SIZE = 100000;

	public static void main(String[] args) {
		Collection<Employee> employeeCollection = 
				EmployeeUtils.generateEmployeeCollection(COLLECTION_SIZE);
		
		System.out.println("Calculating the average salary of employee collection...");
		
		double d1 = employeeCollection
				.stream()
				.sequential()
				.mapToDouble(e -> e.getSalary())
				.average()
				.getAsDouble();
		
		double d2 = employeeCollection
				.stream()
				.parallel()
				.mapToDouble(e -> e.getSalary())
				.average()
				.getAsDouble();
		
		System.out.printf("%nWill the result of average() be the same for parallel and sequential streams?? %b", d1 == d2);
	}
	
}
