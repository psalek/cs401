package lesson10.lecture.threadssingleton;

public class Singleton {
	private static Singleton instance;
	public static int counter = 0;
	private Singleton() {
		incrementCounter();
	}
	public static Singleton getInstance() { 
		if(instance == null) {
			instance = new Singleton();			
		}
		return instance;
	}
	/*synchronized*/ private static void incrementCounter() {
		counter++;
	}
}

 
