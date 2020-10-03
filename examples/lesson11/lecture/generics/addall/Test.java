package lesson11.lecture.generics.addall;
import java.util.*;
public class Test {
	public static void main(String[] args) {
		MyList<Employee> list = new MyListImpl<Employee>();
		Employee e = new Employee("Joe", 100000);
		list.add(e);
		Manager m = new Manager("John", 200000);
		list.add(m);
		MyList<Manager> list2 = new MyListImpl<Manager>();
		list2.add(m);
		list.addAll(list2); //compiler error
		
//		ArrayList<? extends Integer> list3 = new ArrayList<>();
//		list3.add(2);
		
	}
}
