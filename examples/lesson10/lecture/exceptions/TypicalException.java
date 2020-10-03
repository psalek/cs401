package lesson10.lecture.exceptions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TypicalException {
	static void printFile(File f) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(f));
			StringBuilder sb = new StringBuilder();
			String line;
			while((line=reader.readLine()) != null) {
				sb.append(line + ", ");
			}
			String output = sb.toString();
			output = output.substring(0, output.length()-2);
			System.out.println(output);
			reader.close();
		}
		catch(IOException e) {
			System.out.println("Error printing file: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		//not the best way to locate a file
		String userDir = System.getProperty("user.dir");
		String path = userDir + "//src//lesson10//lecture//exceptions//test.txt";
		File f = new File(path);
		printFile(f);
	}

}
