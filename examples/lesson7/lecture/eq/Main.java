package lesson7.lecture.eq;

import java.util.ArrayList;

public class Main {
	static ArrayList<Person> myList = new ArrayList<>();
	static {
		myList.add(new Person("Joe"));
	}
	public static void main(String[] args) {
		Person p1 = new Person("Joe");
		Person p2 = new Person("Joe");
		System.out.println(p1.equals(p2)); //true
		System.out.println(myList.contains(p1));  //false	
	}
}
