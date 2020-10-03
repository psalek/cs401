package lesson8.lecture.functionalprogramming;

public class LackReferentialTransparency {
	
//Calls to compute at different times typically give
//different outputs
public static void main(String[] args) {
	System.out.println(compute(5));
	System.out.println(compute(5));
	
	//NOTE:
	//compiler cannot replace this:
	int y = compute(5) * compute(5);
	//with this
	int z = compute(5);
	y = z * z;
}
public static int compute(int num) {
	return num + (int) (10 * Math.random());
}
}
