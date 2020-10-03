package lesson3.lecture.polymorphism2;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		StaffPerson p1 = new Faculty();
		StaffPerson p2 = new Secretary();
		StaffPerson p3 = new Faculty();
		StaffPerson p4 = new Secretary();
		List<StaffPerson> people = Arrays.asList(p1, p2, p3, p4);
		
		double sum = 0.0;
		//print average stipend
		for(StaffPerson p : people) {
			sum += p.computeStipend();
		}
		System.out.println("Average stipend = " 
				+ (people.isEmpty() ? 0.0 : sum/people.size()));
	}

}
