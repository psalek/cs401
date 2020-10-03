package lesson5.lecture.factorymethods4.singleton;

public class Main {

	
		public static void main(String[] args) {
			for(int i = 0; i < 20; ++i) {
				MySingleton.getInstance();
			}
			System.out.println(MySingleton.countInstances);
			//new MySingleton();
		}

	

}
