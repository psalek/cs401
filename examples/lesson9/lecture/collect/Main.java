package lesson9.lecture.collect;
import java.util.*;
import java.util.stream.Collectors;
public class Main {

	public static void main(String[] args) {
		List<Employee> list = Arrays.asList(
				new Employee("John", 20000), new Employee("Joe", 30000),
				new Employee("Steve", 40000), new Employee("Hal", 50000));
		
		//compiler error -- need to transform Employee objects to strings
		//System.out.println(list.stream().collect(Collectors.joining(", "));
		System.out.println(list.stream()
				               .map(Object::toString)
				               .collect(Collectors.joining(", ")));
//		
//		//or you can specify Employee::toString since that is the type we are considering
		System.out.println(list.stream()
	               .map(Employee::toString)
	               .collect(Collectors.joining(", ")));

	}

}
