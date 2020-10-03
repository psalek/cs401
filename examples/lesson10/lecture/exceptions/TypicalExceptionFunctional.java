package lesson10.lecture.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.stream.Collectors;

public class TypicalExceptionFunctional {
	static void printFile(File f) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			System.out.println(reader.lines().collect(Collectors.joining(", ")));
			reader.close();
		} catch(IOException e) {
			System.out.println("Error printing file: " + e.getMessage());
			
		}
	}
	public static void main(String[] args) {
		//Good way to read
		URL url = TypicalExceptionFunctional.class.getResource("test.txt");
		File f = new File(url.getFile());
		printFile(f);
	}
}
