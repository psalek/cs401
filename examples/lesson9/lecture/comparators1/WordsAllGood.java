package lesson9.lecture.comparators1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.function.*;

/**
 * Sorts words in descending order of length, using the
 * comparing method of Comparator. In goodSort1,
 * the argument to comparing is a lambda; in goodSort2,
 * the argument to comparing is a method reference.
 * 
 */  
public class WordsAllGood {
	public static void main(String[] args) {
		goodSort1();
		goodSort2();
	}
	
	public static void goodSort1() {
		List<String> words = Arrays.asList("Tom", "Joseph", "Richard");
		Stream<String> longestFirst  
		    = words.stream().sorted(Comparator.comparing(String::length).reversed());
		System.out.println(longestFirst .collect(Collectors.toList()));
	}
	
	public static void goodSort2() {
		Function<String, Integer> sortByLength = x -> x.length();
		List<String> words = Arrays.asList("Tom", "Joseph", "Richard");
		Stream<String> longestFirst  
		    = words.stream().sorted(Comparator.comparing(sortByLength).reversed());
		System.out.println(longestFirst .collect(Collectors.toList()));
	}
}
