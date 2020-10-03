package lesson10.lecture.exceptions2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class provides an easy solution -- just provide a companion
 * method that deals with the exception by re-throwing it as a 
 * RuntimeException. This sidesteps the issue of having a
 * FunctionalInterface that is capable of throwing an exception,
 * so this theoretical issue is glossed over. But the solution
 * is more readable and accomplishes the same thing as GenericWrapper.
 *
 */
public class EasierSolution {
	public List<String> getCanonicalPaths(String[] dirs)  {
		return Stream.of(dirs).map(
			path -> getCanonicalPathHelper(path))
			.collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		String[] localDirs = {"/usr", "//usr", "/etc"};
		List<String> canonicalPaths 
			= (new EasierSolution()).getCanonicalPaths(localDirs);
		System.out.println(canonicalPaths);
	}
	
	public static String getCanonicalPathHelper(String path) {
		try {
			return new File(path).getCanonicalPath();
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}
