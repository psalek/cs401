package lesson8.lecture.filter;

import java.util.ArrayList;
import java.util.List;

/** Java 7 way of counting number of names that start with 'N' */
public class Weak {
	public static void main(final String[] args) {
		Weak w = new Weak();
		
		System.out.println(String.format("Friends with names that start"
				+ " with 'N': "+ w.findStartsWithLetterToUpper(Folks.friends, 'N')));
		
		System.out.println(String.format("Editors with names that start"
				+ " with 'M': " + w.findStartsWithLetterToUpper(Folks.editors, 'M')));
		
	}
	
	public List<String> findStartsWithLetterToUpper(List<String> list, char c) {
		List<String> startsWithLetter = new ArrayList<String>();
	    for(String name : list) {
	      if(name.startsWith(""+c)) {
	    	  startsWithLetter.add(name.toUpperCase());
	      }
	    }
	    return startsWithLetter;	
	}
}
