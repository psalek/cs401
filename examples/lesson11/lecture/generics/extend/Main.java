package lesson11.lecture.generics.extend;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Manager> list1 = new ArrayList<>();
		list1.add(new Manager("Joe", 110000, 2002, 1, 15));
		//List<Employee> list2 = list1; //compiler error 
		List<? extends Employee> list3 = list1;
		
		//list3.add(new Manager("Tom", 110000, 2002, 1, 15)); //compiler error
		//list3.addAll(list1);  //compiler error
	}

}
