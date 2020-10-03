package lesson10.lecture.libcompanion_old;
import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;
public class Complex {
	List<String> words = Arrays.asList("friends", "hats", "trees", "orange");
	//Difficult to test
	static Function<List<String>, List<String>> firstToUpperCaseLambda 
         = words -> words.stream()
                         .map(word -> {
              char firstChar = Character.toUpperCase(word.charAt(0));
              return firstChar + word.substring(1);
               }).collect(Collectors.toList());
    public static void main(String[] args) {
    	Complex c = new Complex();
        firstToUpperCaseLambda.apply(c.words).forEach(System.out::println);	 
    }
}
