package lesson3.lecture.inheritance3;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		ExtendedHashSet<String> ehs = new ExtendedHashSet<>();
		ehs.add("A");
		ehs.add("B");
		ehs.add("C");
		System.out.println("Number of attempted adds so far (expected 3): " 
		   + ehs.getAddCount());
		ehs.remove("B");
		System.out.println("Number of attempted adds so far even after removal"				
		+ " (expected 3): " + ehs.getAddCount());
		
		ehs.addAll(Arrays.asList("D", "E", "F"));
		System.out.println("Elements of current set: " + ehs);
		System.out.println("Number of attempted adds so far (expected 6): " 
		        + ehs.getAddCount());
	}

}
