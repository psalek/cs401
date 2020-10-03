package lesson8.lecture.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MapImperative {
	List<String> uppercaseList;
	
	/* Transforms input list so that all strings are upper case
	 * Populates and sorts the uppercaseList with these new values
	 * Prints the new list
	 */
	public void printAsUpperCase(List<String> strings) {
		uppercaseList = new ArrayList<>();
		for(String s : strings) {
			String t = s.trim();
			uppercaseList.add(t.toUpperCase());
		}
		Collections.sort(uppercaseList);
		System.out.println(uppercaseList);	
	}
	
	public static void main(String[] args) {
		MapImperative mi = new MapImperative();
		List<String> list = 
		  Arrays.asList("billy", "tommy  ", " rick  ", "abdul", 
			"albert     ", "isaiah"); 
		mi.printAsUpperCase(list);
	}
}
