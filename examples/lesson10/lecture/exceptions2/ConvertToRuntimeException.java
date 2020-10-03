package lesson10.lecture.exceptions2;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConvertToRuntimeException {
	public List<String> getCanonicalPaths(String[] dirs) {
		return Stream.of(dirs).map(path -> {
			try {
				return new File(path).getCanonicalPath();
			} catch (IOException ex) {
				System.out.println("GOT IOException");
				//turns checked to unchecked 
				throw new RuntimeException(ex); 
			}
		}).collect(Collectors.toList());
	}
	
	public static void main(String[] args) {
		//causes IOException -- but instead of handling it, we get ugly RuntimeException
		String[] localDirs = {"/usr", "/null", "/etc"};
		List<String> canonicalPaths 
			= (new ConvertToRuntimeException()).getCanonicalPaths(localDirs);
		System.out.println(canonicalPaths);
	}

}
