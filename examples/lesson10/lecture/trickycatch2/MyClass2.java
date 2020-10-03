package lesson10.lecture.trickycatch2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * Same as MyClass, but handle exception outside
 * of handleFile method.

 * Problem: If an exception is thrown in the inner
 * try and also in the finally block (both
 * would be IOExceptions), the one that is thrown
 * is the one generated in the finally block, 
 * but this is not the one we want.
 * 
 * 
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
		try{ 
			try { //this is the block containing useful behavior
				//separated from exception-handling block
				fileReader = new FileReader(f);
				buf = new BufferedReader(fileReader);
				String line = buf.readLine();
				System.out.println("Line from file: " + line);
			} finally {
				if(buf != null) buf.close();
				if(fileReader != null) fileReader.close();	
				//simulates exception thrown by buf.close()
				throw new IOException("2nd IOException");  
			}
		} catch(IOException e) {
			//log the exception and rethrow
			log.warning("IOException thrown: " + e.getMessage());
			throw e;
		} 
		
	}
	public static void main(String[] args) {
		MyClass2 cl = new MyClass2();
		try {
			cl.handleFile(new File("textt"));
		} catch(IOException e) {
			log.info(e.getMessage());
			//can't find first exception by examining "cause" either
			//log.info(e.getCause().getMessage());
		}
	}
}
