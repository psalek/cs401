package lesson10.lecture.exceptions2;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TheProblem {

	public List<String> getCanonicalPaths(String[] dirs) throws IOException {
//		return Stream.of(dirs)
//			 .map(path ->
//			         new File(path).getCanonicalPath()) //UNHANDLED IOEXCEPTION
//			 .collect(Collectors.toList());
		return new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		String[] localDirs = {"//usr", ".temp", "/etc"};
		try {
			List<String> canonicalPaths 
				= (new TheProblem()).getCanonicalPaths(localDirs);
			System.out.println(canonicalPaths);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
