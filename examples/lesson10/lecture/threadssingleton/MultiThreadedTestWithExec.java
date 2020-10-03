package lesson10.lecture.threadssingleton;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MultiThreadedTestWithExec {
	private static Executor exec 
	   = Executors.newCachedThreadPool();
	public static void main(String[] args) {	
		for(int i = 0; i < 10; ++i) {
			multipleCalls();
			System.out.println("Num instances: " 
			       + SynchronizedSingleton.counter);
		}
	}
	public static void multipleCalls() {
		Runnable r = () -> {
			for(int i = 0; i < 500; ++i) {
				SynchronizedSingleton.getInstance();
			}
		};
		for(int i = 0; i < 100; ++i) {
			exec.execute(r);		
		}
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {}
	}
}
