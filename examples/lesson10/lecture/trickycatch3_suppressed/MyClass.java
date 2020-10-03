package lesson10.lecture.trickycatch3_suppressed;

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
 * This version uses class from tricky2 and 
 * shows how to retrieve suppressed exceptions.
 * It is extremely complicated, with three levels of nesting, 
 * but works. 
 * 
 * Here we give up the design improvement shown in tricky2
 * in order to keep track of the different exceptions; this
 * design is really an enhancement of tricky1.
 * 
 * MyClass2 shows how it is done when handleFile does not
 * attempt to handle exceptions
 */
public class MyClass {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	@SuppressWarnings("finally")
	public void handleFile(File f) {
		FileReader fileReader = null;
		BufferedReader buf = null;
		IOException ex = null;
		try {
			try{ 
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
		} catch(IOException e) {
			log.warning("Main IOException thrown: " + e.getMessage());
			List<Throwable> suppressed = Arrays.asList(e.getSuppressed());	
			suppressed.forEach(except -> log.info("Suppressed message: " + except.getMessage()));
			
		}
		
	}
	public static void main(String[] args) {
		MyClass cl = new MyClass();
		cl.handleFile(new File("text"));
	}
}
