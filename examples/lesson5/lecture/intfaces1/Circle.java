package lesson5.lecture.intfaces1;

public class Circle {
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
	
	public double computeCircumference() {
		return 2 * Math.PI * radius;
	}
}
