package lesson10.lecture.threadssingleton;

public class SingleThreadedTest1 {

	public static void main(String[] args) {
		for(int i = 0; i < 10000; ++i) {
			Singleton.getInstance();
		}
		System.out.println("Num instances: " + Singleton.counter);
	}
	
}
