package lesson10.lecture.checkedexceptions;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;



public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		File f = new File("DoesntExist");
		

	}
	//First way - declare throws
	public void write1(File f) throws IOException {
		PrintWriter w = new PrintWriter(f);
	}
	
	//Second way - handle directly
	public void write2(File f) {
		try {
			PrintWriter w = new PrintWriter(f);
			//do something
		} catch(IOException e) {
			System.out.println("Something bad happened...");
		}
		
	}
	//Third way -- partially handle and re-throw
	public void write3(File f) throws IOException {
		try {
			PrintWriter w = new PrintWriter(f);
			//do something
		} catch(IOException e) {
			Logger log = Logger.getLogger("");
			log.warning("IOException thrown in Test.write3 method. File is " + f.getAbsolutePath());
			throw e;
		}
		
	}
	public void write4(File f) throws MyException {
		try {
			PrintWriter w = new PrintWriter(f);
			//do something
		} catch(IOException e) {
			throw new MyException(e);
		}
	}
	
	public class MyException extends Exception {
		public MyException() {
			super();
		}
		public MyException(String msg) {
			super(msg);
		}
		public MyException(Throwable t) {
			super(t);
		}
	}

}
