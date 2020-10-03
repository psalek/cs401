package lesson10.lecture.trickycatch4_trywithres;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * This accomplishes the same as trickycatch3, using
 * try-with-resources construct. Guarantees that readers are closed
 * and that any secondary exceptions are available via
 * e.getSuppressed().
 * 
 * Since it's hard to test the secondary exceptions, look
 * at MyClassMyBuf where we have guaranteed that close will fail.
 */
public class MyClass {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	public void handleFile(File f) {
		//try with resources construct
		try (BufferedReader buf = new BufferedReader(new FileReader(f))) {
			String line = buf.readLine();
			System.out.println(line);
		} catch(IOException e) {
			log.warning("Main exception: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except -> log.warning("Suppressed message: " 
			                                         + except.getMessage()));
		}
		
	}
	public static void main(String[] args) {
		MyClass cl = new MyClass();
		cl.handleFile(new File("textt"));
	}
}
