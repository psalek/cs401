/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package lesson9.lecture.optional;


import java.util.List;
import java.util.Optional;

public class PickAnElementIfPresent {
  public static void pickName(
    final List<String> names, final String startingLetter) {
     
	  final Optional<String> foundName = 
		      names.stream()
		           .filter(name ->name.startsWith(startingLetter))
		           .findFirst();
      
	  foundName.ifPresent(name -> System.out.println("Hello " + name));
  }

  public static void main(final String[] args) {

    pickName(Folks.friends, "N");
    pickName(Folks.friends, "Z");

  }
}
