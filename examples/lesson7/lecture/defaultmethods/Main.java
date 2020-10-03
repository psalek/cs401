package lesson7.lecture.defaultmethods;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		PersonInfoQuickView person1 = new PersonInfoQuickView("Joe", "Stevens", "101 Adams",
				"Fairfield", "IA");
		PersonInfoFullView person2 = new PersonInfoFullView("Jim", "Thomas", "Radcliffe",
				"17 Jones Pl.", "Apt. 2E", "New York", "NY", "01215");
		
		List<NameAddress> directory = new ArrayList<>();
		directory.add(person1);
		directory.add(person2);
		print(directory);
	}
	private static void print(List<NameAddress> list) {
		for(NameAddress na : list) {
			//Makes use of the default format method in every case
			System.out.println(na.formattedOutput() + "\n" + "===============");
		}
	}
	
}
