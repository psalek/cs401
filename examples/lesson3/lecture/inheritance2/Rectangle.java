package lesson3.lecture.inheritance2;

public class Rectangle {
	private int side1, side2;
	public Rectangle(int s1, int s2) {
		side1 = s1;
		side2 = s2;
	}
	public int getSide1() {
		return side1;
	}
	public void setSide1(int side1) {
		this.side1 = side1;
	}
	public int getSide2() {
		return side2;
	}
	public void setSide2(int side2) {
		this.side2 = side2;
	}
	public int computeArea() {
		return side1 * side2;
	}
	public String toString() {
		return "Dimensions of this " + getClass().getSimpleName() + ": side1 = " + side1 + ", side2 = " + side2;
	}
}
