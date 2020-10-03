package lesson10.lecture.threadssingleton;

/** Same as MultiThreadedTest but uses Singleton2 where counter is threadsafe */
public class MultiThreadedTest2 {	
	public static void main(String[] args) {	
		for(int i = 0; i < 10; ++i) {
			multipleCalls();
			System.out.println("Num instances: " + Singleton2.counter);
		}		
	}
	public static void multipleCalls() {
		Runnable r = () -> {
			for(int i = 0; i < 5000; ++i) {
				Singleton2.getInstance();
			}
		};
		for(int i = 0; i < 1000; ++i) {
			new Thread(r).start();			
		}
	}
}
