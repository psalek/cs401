package lesson5.lecture.intfaces1;

public class Rectangle {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double computePerimeter() {
		return 2 * length + 2 * width;
	}
	
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
}
