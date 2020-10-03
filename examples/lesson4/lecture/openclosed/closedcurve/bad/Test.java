package lesson4.lecture.openclosed.closedcurve.bad;

class Test {
	public static void main(String[] args) {

		Object[] objects = { new Triangle(5, 5, 5), new Square(3),
				new Circle(3) };
		// compute areas
		for (Object o : objects) {
			if (o instanceof Triangle) {
				Triangle t = (Triangle) o;
				System.out.println(t.computeArea());
			}
			if (o instanceof Square) {
				Square s = (Square) o;
				System.out.println(s.computeArea());
			}
			if (o instanceof Circle) {
				Circle c = (Circle) o;
				System.out.println(c.computeArea());
			}
		}
	}
}
