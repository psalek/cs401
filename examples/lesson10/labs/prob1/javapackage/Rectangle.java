package lesson10.labs.prob1.javapackage;

import lesson10.labs.prob1.bugreporter.BugReport;

@BugReport(assignedTo="Joe Smith", severity=2, reportedBy="Corazza", description="computePerimeter incorrect")
public class Rectangle implements ClosedCurve {
	private double length, width;
	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double computePerimeter() {
		return length + width;
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
