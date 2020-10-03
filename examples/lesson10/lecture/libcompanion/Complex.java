package lesson10.lecture.libcompanion;
import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;
public class Complex {
	//difficult to test
	static Function<List<Employee>, List<Employee>> employeeSorter =
		list -> list.stream()
        .sorted(Comparator.comparing((Employee e) -> e.getName())
     		             .thenComparing((Employee e) -> e.getSalary(), 
     		            		 Comparator.reverseOrder()))
        .collect(Collectors.toList());
	
	
    public static void main(String[] args) {
    	Complex c = new Complex();
    	List<Employee> list = TestClass.data();
        System.out.println(list);
    	System.out.println(employeeSorter.apply(list));
    	
    }
}
