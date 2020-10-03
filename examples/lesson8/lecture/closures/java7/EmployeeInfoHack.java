package lesson8.lecture.closures.java7;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/** Shows how the "effectively final" rule can be broken -- but shouldn't be done */
public class EmployeeInfoHack {
	
		static enum SortMethod {BYNAME, BYSALARY};
		private boolean ignoreCase = true;
		public void setIgnoreCase(boolean b) {
			ignoreCase = b;
		}
	public void sort(List<Employee> emps, final SortMethod[] methodArr) {
		class EmployeeComparator implements Comparator<Employee> {
			@Override
			public int compare(Employee e1, Employee e2) {
				SortMethod method = methodArr[0];
				//mutating the contents of methodArr -- bad 
				if(method == SortMethod.BYNAME) method = SortMethod.BYSALARY;
				else method = SortMethod.BYNAME;
				
				if(method == SortMethod.BYNAME) {
					//instance vble ignoreCase does not need to be final
					if(ignoreCase) return e1.name.compareToIgnoreCase(e2.name);
					else return e1.name.compareTo(e2.name);
				} else {
					if(e1.salary == e2.salary) return 0;
					else if(e1.salary < e2.salary) return -1;
					else return 1;
				}
			}
		}
		Collections.sort(emps, new EmployeeComparator());
	}

}
