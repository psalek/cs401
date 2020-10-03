package lesson10.lecture.trickycatch3_suppressed;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;


/**
 * Same as MyClass but changes three levels of nesting
 * to something more realistic -- handle method throws
 * an IOException now and caller can gather results
 */
public class MyClass2 {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	@SuppressWarnings("finally")
	public void handleFile(File f) throws IOException {
		FileReader fileReader = null;
		BufferedReader buf = null;
		IOException ex = null;	
		try { 
			try {
				fileReader = new FileReader(f);
				buf = new BufferedReader(fileReader);
				String line = buf.readLine();
				System.out.println("Line from file: " + line);
			} catch(IOException e) {
				ex = e;
				throw e;
			}
		} finally {
			try {
				if(buf != null) buf.close();
				if(fileReader != null) fileReader.close();	
				//simulates exception thrown by buf.close()
				throw new IOException("2nd IOException");  
			} catch(IOException exc) {
				if(ex != null) {
					ex.addSuppressed(exc);
					throw ex;
				} else {
					throw exc;
				}
			}			
		}	
	}
	public static void main(String[] args) {
		MyClass2 cl = new MyClass2();
		try {
			cl.handleFile(new File("textt"));
		} catch(IOException e) {
			log.info("Main IOException thrown: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except -> log.info("Suppressed message: " + except.getMessage()));
			
		}
	}
}
