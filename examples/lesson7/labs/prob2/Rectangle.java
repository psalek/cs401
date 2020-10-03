package lesson7.labs.prob2;

public final class Rectangle implements ClosedCurve {
	final private double width;
	final private double length;
	
	@Override
	public double computePerimeter() {
		double area =  width * length;
		return area;
	}
	public Rectangle(double width, double length) {	
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return width;
	}
	public double getLength() {
		return length;
	}
}
