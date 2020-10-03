package lesson10.lecture.threadssingleton;

public class Singleton2 {
	private static Singleton2 instance;
	public static int counter = 0;
	private Singleton2() {
		incrementCounter();
	}
	public static Singleton2 getInstance() { 
		if(instance == null) {
			instance = new Singleton2();			
		}
		return instance;
	}
	/* Guarantees proper count of instances */
	synchronized private static void incrementCounter() {
		counter++;
	}
}
