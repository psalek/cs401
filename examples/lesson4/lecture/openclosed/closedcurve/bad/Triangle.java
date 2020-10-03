package lesson4.lecture.openclosed.closedcurve.bad;

import java.util.Arrays;

public final class Triangle  {
	/** base and height variables are defined so that height <= base */
	private final double base;
	private final double height;
	
	/** sides of the triangle, defined so that side1 <= side2 <= side3 */
	private final double side1, side2, side3;
	private static final double DEFAULT_SIDE = 5.0;
	
	/**
	 * This constructor accepts base and height of triangle and 
	 * makes the assumption base and height are two of the sides of the triangle.
	 * <p>Postcondition: Constructor must assign values to side variables so that
	 * the following is satisfied: side1 <= side2 <= side3.
	 * <p>Postcondition: Constructor must assign values to height and base so that
	 * the following is satisfied: height <= base
	 */
	public Triangle(double base, double height){
		if (height <= base) {
			this.base = base;
			this.height = height;
		} 
		else {
			this.base = height;
			this.height = base;
		}
		side1 = height;
		side2 = base;
		side3 = Math.sqrt(base * base + height * height);	
		//verify during development and testing that postconditions are met
		assert(side1 <= side2 && side2 <= side3);
		assert(height <= base);
	}
	
	/**
	 * A constructor that accepts 3 sides as arguments and computes (and sets)
	 * the base and height under the assumption that base and height are two of the sides. 
	 * <p>Postcondition: Side variables must be assigned so that the following is satisfied:
	 * side1 <= side2 <= side3
	 * <p>Postcondition: Base and height variables must be assigned so that the following is
	 * satisfied: height <= base
	 * <p>Algorithm: The formula (in x, y, z) used here for computing the height
	 * of a triangle, given its sides, depends on the fact that
	 * the z is the longest side. The formula then is obtained by
	 * solving two equations for h simultaneously: 
	 * <code>
	 *   u*u + h*h = x*x
	 *   (z-u) * (z-u) + h*h = y*y
	 *  </code>
	 */
	public Triangle(double s1, double s2, double s3)  {
		double[] arr = {s1, s2, s3};
		Arrays.sort(arr);		
		double x = arr[0];
		double y = arr[1];
		double z = arr[2];
		if(x + y < z) {
			//TODO: Throw an exception here...
			System.out.println("Illegal sizes for a triangle: " + s1 + ", " + s2+", " + s3);
			System.out.println("Creating an equilateral triangle with side = " + DEFAULT_SIDE);
			x = y = z = DEFAULT_SIDE;
		}
		side1 = x;
		side2 = y;
		side3 = z;
		double u = (y * y - x * x + z * z)/(2 * z);
		double h = Math.sqrt(y * y - u * u);
		base = z;
		height = h;	
		assert(side1 <= side2 && side2 <= side3);
		assert(height <= base);
	}
	public double computeArea() {
		return (0.5 * base * height);
	}
}
