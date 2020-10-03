package lesson5.lecture.intfaces2;

public class Circle implements ClosedCurve, Shape {
	private double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	@Override
	public double computePerimeter() {
		return 2 * Math.PI * radius;
	}
}
