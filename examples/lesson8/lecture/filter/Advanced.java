package lesson8.lecture.filter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class Advanced {
	final BiFunction<List<String>, String, List<String>> listStartsWith 
	    = (list, letter) -> list.stream()
	                            .filter(name -> name.startsWith(letter))
	                            .collect(Collectors.toList());    

	final List<String> friendsStartN = listStartsWith.apply(Folks.friends, "N");

	final List<String> friendsStartB = listStartsWith.apply(Folks.friends, "B");

	public static void main(String[] args) {
		Advanced adv = new Advanced();

		System.out.println("Friends with names that start" + " with 'N': "
				+ adv.friendsStartN);
		System.out.println("Friends with names that start" + " with 'B': "
				+ adv.friendsStartB);
	}
	
}
