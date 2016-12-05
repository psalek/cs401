package edu.mum.cs.cs401.examples.java8.streams.parallel;

import java.util.Collection;

import edu.mum.cs.cs401.examples.java8.pojos.Employee;
import edu.mum.cs.cs401.examples.java8.utils.EmployeeUtils;
import edu.mum.cs.cs401.examples.java8.utils.Timer;

/**
 * Using Stream API to average over a collection of items
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class EmployeeApp3 {
	
	private static final int TEST_SIZE = 50;
	
	private static final int COLLECTION_SIZE = 1000000;

	public static void main(String[] args) {
		Collection<Employee> employeeCollection = 
				EmployeeUtils.generateEmployeeCollection(COLLECTION_SIZE);
		
		System.out.print("Calculating average salary...");		

		long regularTimeTaken = 0;
		long parallelTimeTaken = 0;
		
		for(int i = 0; i < TEST_SIZE; ++i) {
			parallelTimeTaken += parallelStreamAverage(employeeCollection);
			regularTimeTaken += regularStreamAverage(employeeCollection);
		}
		
		System.out.println("\n");
		
		System.out.printf("Regular stream took a total of %,d milliseconds for %,d iterations of a collection of %,d employees\n", regularTimeTaken, TEST_SIZE, COLLECTION_SIZE);
		System.out.printf("Parallel stream took a total of %,d milliseconds for %,d iterations of a collection of %,d employees\n", parallelTimeTaken, TEST_SIZE, COLLECTION_SIZE);
	}
	
	private static long regularStreamAverage(Collection<Employee> employeeCollection) {
		Timer.start();
		employeeCollection.stream().filter(e -> e.getAge() > 40).mapToDouble(e -> e.getSalary()).average();
		Timer.stop();
		
		return Timer.getDuration();
	}

	private static long parallelStreamAverage(Collection<Employee> employeeCollection) {
		Timer.start();
		employeeCollection.parallelStream().filter(e -> e.getAge() > 40).mapToDouble(e -> e.getSalary()).average();
		Timer.stop();
		
		return Timer.getDuration();
	}

}
