package lesson7.labs.prob1.partC;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeInfo {
	
	
	/**
	 * Removes all duplicate Employee instances from input list (only a copy is modified)
	 * An Employee instance is considered to be a duplicate of another Employee
	 * instance if the two instances have the same name and salary.
	 */
	public static List<Employee> removeDuplicates(List<Employee> employees) {
		HashMap<Employee, Employee> tracker = new HashMap<>();
		List<Employee> noDupsList = new ArrayList<>();
		for(int i = 0; i < employees.size(); ++i) {
			Employee e = employees.get(i);
			if(!tracker.containsKey(e)) {
				tracker.put(e, e);
				noDupsList.add(e);
			}
		}
		return noDupsList;
	}
	
	
	
	/**
	 * Tests to see if solution is correct
	 * What's wrong here?
	 */
	public static void main(String[] args) {	
		List<Employee> list = new ArrayList<Employee>() {
			{
				add(new Employee("Richard", 55000));
				add(new Employee("Richard", 55000));
				add(new Employee("John", 30000));
				add(new Employee("Steve", 30000));
				add(new Employee("Zeke", 50000));
				add(new Employee("Reggie", 50000));
				add(new Employee("Steve", 30000));
				add(new Employee("John", 70000));
				add(new Employee("Harold", 55000));
				add(new Employee("Richard", 55000));
				add(new Employee("Richard", 55000));
				add(new Employee("Richard", 60000));
				add(new Employee("Dennis", 80000));
				add(new Employee("Adam", 80000));
				add(new Employee("John", 70000));
				add(new Employee("Charles", 25000));
				add(new Employee("Bill", 60000));
				add(new Employee("Bob", 60000));
				add(new Employee("Bill", 70000));
				add(new Employee("Bob", 60000));
			}
		};
		
		//List with duplicates removed - correctly computed
		List<Employee> dupsRemoved = new ArrayList<Employee>() {
			{
				add(new Employee("Richard", 55000));
				add(new Employee("John", 30000));
				add(new Employee("Steve", 30000));
				add(new Employee("Zeke", 50000));
				add(new Employee("Reggie", 50000));
				add(new Employee("John", 70000));
				add(new Employee("Harold", 55000));
				add(new Employee("Richard", 60000));
				add(new Employee("Dennis", 80000));
				add(new Employee("Adam", 80000));
				add(new Employee("Charles", 25000));
				add(new Employee("Bill", 60000));
				add(new Employee("Bill", 70000));
				add(new Employee("Bob", 60000));
			}
		};

		List<Employee> answer = removeDuplicates(list);
		System.out.println("Is answer correct? " + listsAreEqual(answer, dupsRemoved));
	}
	
	/**
	 * Returns true if the two lists have the same size and contain exactly the same
	 * elements (this is really just set equality)
	 */
	public static boolean listsAreEqual(List<Employee> l1, List<Employee> l2) {
		if(l1.size() != l2.size()) return false;
		for(Employee e : l1) {
			if(!l2.contains(e)) return false;
		}
		return true;
	}

	 
}
