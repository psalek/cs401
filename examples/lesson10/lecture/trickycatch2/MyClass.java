package lesson10.lecture.trickycatch2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;


/**
 * This version improves readability 
 * from previous package trickycatch1 --
 * inner try/finally are concerned with doing
 * something with program execution (namely, the readers); 
 * outer try/catch
 * are concerned with exception handling
 * 
 * In MyClass2, we handle exception outside of the handleFile
 * method.
 */
public class MyClass {
	private static final Logger log;
	static {
		LogSetup.setup();
		log = Logger.getGlobal();
	}
	public void handleFile(File f) {
		FileReader fileReader = null;
		BufferedReader buf = null;
		try{ 
			try {
				fileReader = new FileReader(f);
				buf = new BufferedReader(fileReader);
				String line = buf.readLine();
				System.out.println("Line from file: " + line);
			} finally {
				if(buf != null) buf.close();
				if(fileReader != null) fileReader.close();	
				//throw new IOException("2nd IOException");  //simulates exception thrown by buf.close()
			}
		} catch(IOException e) {
			log.warning("IOException thrown: " + e.getMessage());
		} 
		
	}
	public static void main(String[] args) {
		MyClass cl = new MyClass();
		cl.handleFile(new File("text"));
	}
}
