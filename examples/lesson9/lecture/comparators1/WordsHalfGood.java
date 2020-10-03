package lesson9.lecture.comparators1;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/** Sorts words in descending order of length, using a lambda-defined
 *  Comparator.
 *
 */
public class WordsHalfGood {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("Tom", "Joseph", "Richard");
		Stream<String> longestFirst  = words.stream().sorted((String x, String y) -> 
		    (new Integer(y.length()).compareTo(new Integer(x.length()))));
		System.out.println(longestFirst .collect(Collectors.toList()));
	}
	
}
