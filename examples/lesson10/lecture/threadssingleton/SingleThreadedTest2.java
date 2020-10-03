package lesson10.lecture.threadssingleton;


public class SingleThreadedTest2 {
	public static void main(String[] args) {
		for(int i = 0; i < 10; ++i) {
			createAndStartThread();
			System.out.println("Num instances: " + Singleton.counter);		
		}
	}
	public static void createAndStartThread() {
		Runnable r = () -> {
			for(int i = 0; i < 1000; ++i) {
				Singleton.getInstance();
			}		
		};
		new Thread(r).start();
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {}
	}
}
