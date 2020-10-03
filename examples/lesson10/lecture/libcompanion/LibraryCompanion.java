package lesson10.lecture.libcompanion;

import java.util.Comparator;

public class LibraryCompanion {
	static Comparator<Employee> empComp 
	   = Comparator.comparing((Employee e) -> e.getName())
	        .thenComparing((Employee e) -> e.getSalary(), 
	            Comparator.reverseOrder());
	public static int compareEmps(Employee e1, Employee e2) {
		return empComp.compare(e1, e2);
	}
}

