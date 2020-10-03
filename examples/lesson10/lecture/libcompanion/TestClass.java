package lesson10.lecture.libcompanion;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TestClass {
	/* Tests core piece of employeeSorter */
	@Test
    public void compareEmployees() {
		Employee joe1 = new Employee("Joe", 50000);
		Employee joe2 = new Employee("Joe", 70000);
		Employee jim = new Employee("Jim", 70000);
		
		//verify that jim comes before joe
		assert(LibraryCompanion.compareEmps(jim, joe1) < 0);
		
		//verify that joe2 comes before joe1
		assert(LibraryCompanion.compareEmps(joe2, joe1) < 0);
    }
	
	//Can also test sorted order
	@Test
	public void testSortedOrder() {
		List<Employee> input = data();
		List<Employee> sorted = sorted();
		assertEquals(sorted, ComplexMethRef.employeeSorter.apply(input));
 		
		
	}
	public static List<Employee> data() {
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Joe", 50000));
				add(new Employee("Jim", 75000));
				add(new Employee("Tom", 80000));
				add(new Employee("Jim", 70000));
				add(new Employee("Steve", 55000));
				add(new Employee("Jim", 100000));
				add(new Employee("Joe", 59000));
				add(new Employee("Rich", 88000));
			}
		};
		return list;
	}

	public static List<Employee> sorted() {
		//the list in sorted order
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Jim", 100000));
				add(new Employee("Jim", 75000));
				add(new Employee("Jim", 70000));
				add(new Employee("Joe", 59000));
				add(new Employee("Joe", 50000));
				add(new Employee("Rich", 88000));
				add(new Employee("Steve", 55000));
				add(new Employee("Tom", 80000));
			}
		};
		return list;
	}
	

}
