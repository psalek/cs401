package lesson2.lecture.dependencyexample;

/* Example of a dependency relationship from RightTriangle
 * to java.lang.Math
 */
public class RightTriangle {
	public static double computeHypotenuseLength(double base, double height) {
		return Math.sqrt(base * base + height * height);
	}
}
