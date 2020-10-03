package lesson7.lecture.reviewofinner.singletons;
/*
 * Sol 4
 * Spring way
 * lazy, threadsafe
 * all spring beans are managed as singletons in just this way
 */
public class SingletonAsInnerClass {
	private static class MySingletonHolder {
		private static SingletonAsInnerClass instance = new SingletonAsInnerClass();
	}
	private SingletonAsInnerClass() {
		System.out.println("constructing now...");
	}
	public static SingletonAsInnerClass getInstance() {
		System.out.println("call to getInstance()");
		return MySingletonHolder.instance;
	}

	public static void main(String[] args) {
		System.out.println("Main method first call");
		// comment out and you see the instance is not created
		SingletonAsInnerClass.getInstance();
		System.out.println("Try to get the singleton instance again...");
		SingletonAsInnerClass.getInstance();
	}

}
