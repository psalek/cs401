package lesson7.lecture.singletons;

/** Singleton with lazy initialization. Not threadsafe */
public class MySingletonLazy{
	private static MySingletonLazy instance = null;
	private MySingletonLazy() {}
	public static MySingletonLazy getInstance() {
		if(instance == null) {
			instance = new MySingletonLazy();
		}
		return instance;
	}
	
	
}
