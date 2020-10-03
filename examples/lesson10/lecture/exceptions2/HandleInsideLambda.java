/***
 * Excerpted from "Functional Programming in Java",
 * published by The Pragmatic Bookshelf.
 * Copyrights apply to this code. It may not be used to create training material, 
 * courses, books, articles, and the like. Contact us if you are in doubt.
 * We make no guarantees that this code is fit for any purpose. 
 * Visit http://www.pragmaticprogrammer.com/titles/vsjava8 for more book information.
 ***/
package lesson10.lecture.exceptions2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.io.File;
import java.io.IOException;

/** Convert to RuntimeException inside the lambda expression.*/
public class HandleInsideLambda {

	public List<String> getCanonicalPaths(String[] dirs) {
		return Stream.of(dirs).map(path -> {
			try {
				return new File(path).getCanonicalPath();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		}).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		String[] localDirs = {"//usr", ".temp", "/etc"};
		List<String> canonicalPaths 
			= (new HandleInsideLambda()).getCanonicalPaths(localDirs);
		System.out.println(canonicalPaths);
	}

}
