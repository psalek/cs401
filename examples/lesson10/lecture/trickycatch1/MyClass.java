package lesson10.lecture.trickycatch1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * Same as MyClass, but now we throw any
 * exception that occurs. Good idea to
 * have a finally clause still for cleanup.
 * Also, it's good to have a catch block
 * to log the exception. 
 * 
 * However, not the best design. Can refactor
 * so that one block handles the important
 * program execution, another handles all exceptions
 * that arise. See lesson10.lecture.trickycatch2
 *
 */
public class MyClass {
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
			fileReader = new FileReader(f);
			buf = new BufferedReader(fileReader);
			String line = buf.readLine();
			System.out.println("Line from file: " + line);
		} catch(IOException e) {
			//log.config("Debug Statement: Caught 1st IOException: " + e.getMessage());
			throw(e);
			//throw new IOException("1st IOException: " + e.getMessage());
		} finally {
			try {
				if(buf != null) buf.close();
				if(fileReader != null) fileReader.close();
				//force an exception to be thrown for demo
				throw new IOException("Caught 2nd IOException: error closing readers");
			} catch(IOException e) {
				//log.config(e.getMessage());
				throw(e);
			}		
		} 	
	}
	
	public static void main(String[] args) {
		MyClass cl = new MyClass();
		try {
			cl.handleFile(new File("textt"));
		} catch(IOException e) {
			log.warning("IOException thrown: " + e.getMessage());
		}
	}
}
