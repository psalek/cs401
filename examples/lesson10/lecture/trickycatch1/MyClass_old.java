package lesson10.lecture.trickycatch1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/**
 * This code works -- it catches both exceptions
 * if they are both thrown, and writes a message to
 * the console in each case.
 * 
 * In larger application, you will need to propagate
 * exceptions to an appropriate handler. In this case,
 * it is difficult to do this because there are two
 * exceptions.
 *
 */
public class MyClass_old {
	private static final Logger LOG;
	static {
		LogSetup.setup();
		LOG = Logger.getGlobal();
	}
	
	public void handleFile(File f)  {
		FileReader fileReader = null;
		BufferedReader buf = null;
		try{ 
			fileReader = new FileReader(f);
			buf = new BufferedReader(fileReader);
			String line = buf.readLine();
			System.out.println("Line from file: " + line);
		} catch(IOException e) {
			LOG.warning("1st IOException: " 
				+ e.getMessage());
		} finally {
			try {
				if(buf != null) buf.close();
				if(fileReader != null) fileReader.close();
				throw new IOException("Caught 2nd IOException: error closing readers");
			} catch(IOException e) {
				LOG.warning(e.getMessage());
			}			
		} 	
	}
	public static void main(String[] args) {
		MyClass_old cl = new MyClass_old();
		cl.handleFile(new File("textt"));
	}
	
	
}
