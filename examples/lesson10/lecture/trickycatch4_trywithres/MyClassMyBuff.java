package lesson10.lecture.trickycatch4_trywithres;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * This is the same as MyClass, but we use MyBufferedReader
 * to illustrate the case when close throws an exception.
 * 
 * To get the fail to happen, we make sure readLine fails --
 * this would be the "main" exception we would be concerned about.
 * 
 * Then we make sure close also fails. This should be a suppressed
 * exception. Notice that we can arrange for close in FileReader
 * and in BufferedReader to fail separately and obtain suppressed
 * exception in each case.
 * 
 * The try-with-resources construct satisfies these requirements.
 */
public class MyClassMyBuff {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	public void handleFile(File f) {
		//try with resources
		try (MyBufferedReader buf = new MyBufferedReader(new MyFileReader(f))) {
			String line = buf.readLine();
			System.out.println(line);
		} catch(IOException e) {
			log.warning("Main exception: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except -> log.warning("Suppressed message: " + except.getMessage()));
		} 
		
	}
	public static void main(String[] args) {
		MyClassMyBuff cl = new MyClassMyBuff();
		cl.handleFile(new File("textt"));
	}
}
