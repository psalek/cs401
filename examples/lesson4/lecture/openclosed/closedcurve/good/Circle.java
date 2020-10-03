package lesson4.lecture.openclosed.closedcurve.good;

public final class Circle extends ClosedCurve {
	private final double radius;
	public Circle(double radius) {
		this.radius = radius;
	}
	public double computeArea() {
		return (Math.PI * radius * radius);
	}
}
