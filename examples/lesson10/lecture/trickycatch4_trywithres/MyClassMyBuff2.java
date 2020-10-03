package lesson10.lecture.trickycatch4_trywithres;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * This is the same as MyClassMyBuff, but we don't handle exceptions
 * in handleFile 
 */
public class MyClassMyBuff2 {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	public void handleFile(File f) throws IOException {
		//try with resources
		try (MyBufferedReader buf = new MyBufferedReader(new MyFileReader(f))) {
			String line = buf.readLine();
			System.out.println(line);
		} 
		
	}
	public static void main(String[] args) {
		MyClassMyBuff2 cl = new MyClassMyBuff2();
		try {
			cl.handleFile(new File("text"));
		} catch(IOException e) {
			log.warning("Main exception: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except ->log.warning("Suppressed message: " 
			                                        + except.getMessage()));
		} 
	}
}
