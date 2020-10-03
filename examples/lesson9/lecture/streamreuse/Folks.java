/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
***/
package lesson9.lecture.streamreuse;

import java.util.Arrays;
import java.util.List;

public class Folks {
  public static
  final List<String> friends = 
    Arrays.asList("Brian", "Bob", "Neal", "Raju", "Sara", "Scott");

    public static

  final List<String> editors = 
    Arrays.asList("Brian", "Jackie", "Nick", "Neal", "John", "Mike");

public static

  final List<String> comrades =                      
    Arrays.asList("Kate", "Ken", "Nick", "Paula", "Zach");
}
