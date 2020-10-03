package lesson10.lecture.logging.defaultlogging;

import java.io.File;
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogSetup {
	private static String logDir = System.getProperty("user.dir") + "\\src\\logs\\";
	private static String pattern = "javalog%g.log";
	public static void setup() {
		Logger log = Logger.getGlobal();
		log.setLevel(Level.CONFIG);
		log.setUseParentHandlers(false);
		Handler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.CONFIG);
		consoleHandler.setFormatter(new CustomerSimpleFormatter());
		log.addHandler(consoleHandler);
		try {
			createLogDirIfNecessary();
			System.out.println(logDir  + "javalog");
			FileHandler fileHandler = 
				new FileHandler(logDir + "javalog%g.log", 50000, 2, true);
			fileHandler.setLevel(Level.INFO);
			log.addHandler(fileHandler);
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	private static void createLogDirIfNecessary() {
		File f = new File(logDir);
		if(!f.exists()) {
			f.mkdir();
		}
	}
}
