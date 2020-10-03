package lesson7.lecture.reviewofinner.fourexamples;

public class Anonymous {
	interface IPair {
		public void printHello();
	};
	
	private String name = "Joe";
	public void printPair(int x, int y) {
		(new IPair() {
			int first = x;
			int second = y;
			
			public String toString() {
				
				return "(" + first + ", " + 
			               second + ")";
			}
			public void printHello() {
				name = "Tom";
				System.out.println("Hello " + 
			         name + "\n" + this);
				
			}
		}).printHello();
	}	
	public static void main(String[] args) {
		(new Anonymous()).printPair(11, 3);
	}
}
