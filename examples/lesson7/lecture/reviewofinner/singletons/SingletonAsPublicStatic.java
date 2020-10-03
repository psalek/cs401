package lesson7.lecture.reviewofinner.singletons;

/*
 * Sol 2
 * Thread safe
 * easy initialization
 */
public class SingletonAsPublicStatic {
	public static final SingletonAsPublicStatic INSTANCE 
		= new SingletonAsPublicStatic();
	
	private SingletonAsPublicStatic() {}
	
	public static void main(String[] args) {
		SingletonAsPublicStatic singleton = SingletonAsPublicStatic.INSTANCE;
	}
}
