package lesson10.lecture.logging.defaultlogging2;

import java.util.logging.Logger;

import lesson10.lecture.logging.defaultlogging.LogSetup;

/** 
 * This test will work provided logsetup.jar was added
 * to the project as an external jar.
 * @author pcorazza
 *
 */
public class Test {

	public static void main(String[] args) {
		LogSetup.setup();
		Logger log = Logger.getGlobal();
		log.config("test debug");
		log.info("test filehandler");
		
		//this is a separate logger, using java's default configuration
//		Logger log2 = Logger.getLogger("");
//		log2.config("test log2");  //won't show up
//		log2.info("test log2"); //shows up with different formatting
//		

	}

}
