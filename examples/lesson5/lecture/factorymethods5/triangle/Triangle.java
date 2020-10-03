package lesson5.lecture.factorymethods5.triangle;

import java.util.Arrays;

/**
 * You can create a triangle by specifying three sides or two sides and an
 * included angle.
 * This class shows how both can be done, but factory methods need to be
 * used for constructing triangles in these different ways, since the three
 * parameters in each case are all the same type (so you can't overload
 * constructors with such parameters).
 *
 */
public final class Triangle {
	private double a, b, c;   //the sides
	private double A, B, C;   //the angles
	
	private Triangle() {}
	
	/** Uses Law of Cosines to compute angles */
	public static Triangle fromThreeSides(double side1, double side2, double side3) {
		Triangle t = new Triangle();
		t.a = side1;
		t.b = side2;
		t.c = side3;
		//compute A
		double cosA = (t.b*t.b + t.c*t.c - t.a*t.a)/(2*t.b*t.c);
		t.A = Math.acos(cosA);
		//compute B
		double cosB = (t.c*t.c + t.a*t.a - t.b*t.b)/(2*t.c*t.a);
		t.B = Math.acos(cosB);
		//compute C
		double cosC = (t.a*t.a + t.b*t.b - t.c*t.c)/(2*t.a*t.b);
		t.C = Math.acos(cosC);
		
		return t;
		
	}
	/** Uses Law of Cosines and Law of Sines to solve the triangle
	 * @param includedAngle - value between 0 and PI radians
	 */
	public static Triangle fromTwoSidesInclAngle(double side1, double side2, double includedAngle) {
		Triangle t = new Triangle();
		t.a = side1;
		t.b = side2;
		t.C = includedAngle;
		//compute c
		double cSquared = t.a * t.a + t.b * t.b - 2*t.a*t.b*Math.cos(t.C);
		t.c = Math.sqrt(cSquared);
		//compute A
		double sinA = (t.a*Math.sin(t.C))/t.c;
		t.A = Math.asin(sinA);
		//compute B
		double sinB = (t.b*Math.sin(t.C))/t.c;
		t.B = Math.asin(sinB);
		
		return t;
		
	}
	public static double[] getSides(Triangle t) {
		return new double[]{t.a, t.b, t.c};
	}
	public static double[] getAngles(Triangle t) {
		return new double[]{t.A, t.B, t.C};
	}
	
	public static void main(String[] args) {
		Triangle t = Triangle.fromThreeSides(1,  1,  1);
		System.out.println(Arrays.toString(Triangle.getAngles(t)));
		t = Triangle.fromTwoSidesInclAngle(1, 1, Math.PI/2);
		System.out.println(Arrays.toString(Triangle.getSides(t)));
	}
	
}
