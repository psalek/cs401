package lesson10.lecture.libcompanion_old;
import java.util.function.*;
import java.util.*;
import java.util.stream.Collectors;

public class ComplexMethRef {
   static Function<List<String>, List<String>> firstToUpperCaseLambda 
          = words -> words.stream()
                          .map(LibraryCompanion::firstToUpper) 
                          .collect(Collectors.toList());
   public static void main(String[] args) {
  	  Complex c = new Complex();
      firstToUpperCaseLambda.apply(c.words).forEach(System.out::println);	 
   }
}
