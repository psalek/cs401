package lesson9.lecture.lazystream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Provides a look at the "under-the-hood" implementation of
 * a stream pipeline. Even though intermediate operations appear
 * to produce a new stream at each step, the code is retooled
 * by the compiler so that one element from input is processed
 * at a time until a final output is obtained. This makes it possible
 * to stop processing after a certain limit is reached.
 * 
 * Try stepping through the pipeline example with the debugger -- you will
 * see that no processing occurs until the terminal operation is executed
 *
 */
public class GoodVerbose { 
	
	public static void main(final String[] args) {
		GoodVerbose good = new GoodVerbose();
		//good.findStartsWithLetterNoTerminal(Folks.friends, "N");
		//good.findStartsWithLetterOld(Folks.friends, "N");
		//good.findStartsWithLetterLimit(Folks.friends, "N");
		//good.findStartsWithLetter(Folks.friends, "N")
		System.out.println(String.format("Friends with names that start"
				+ " with 'N': "+ good.findStartsWithLetterLimit(Folks.friends, "N")));
		
	}
	/**
	 * 
	 */
	public List<String> findStartsWithLetterLimit(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .limit(2)
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public void findStartsWithLetterNoTerminal(List<String> list, String letter) {
		
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name));  //maps each string to upper case string
         	     
	}
	
	public List<String> findStartsWithLetterOld(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> name.startsWith(letter)) //returns filtered stream
         	     .map(name -> name.toUpperCase())  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	public List<String> findStartsWithLetter(List<String> list, String letter) {
		return 
		     list.stream()   //convert list to stream
         	     .filter(name -> starts(name,letter)) //returns filtered stream
         	     .map(name -> toUpper(name))  //maps each string to upper case string
         	     .collect(Collectors.toList()); //organizes into a list		
	}
	
	
	public boolean starts(String word, String letr) {
		System.out.println("FILTERing " + word + " to check if it starts with " + letr);
		return word.startsWith(letr);
	}
	
	public String toUpper(String word) {
		System.out.println("MAPping " + word + " to convert to upper case.");
		return word.toUpperCase();
	}
	
	
}
