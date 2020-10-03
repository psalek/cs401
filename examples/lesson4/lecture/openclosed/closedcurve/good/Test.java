package lesson4.lecture.openclosed.closedcurve.good;

public class Test {
	
	public static void main(String[] args) {

		ClosedCurve[] objects = {new Triangle(4,5,6),
								 new Square(3),
								 new Circle(3)};
		//compute areas
		for(ClosedCurve cc : objects) {
			System.out.println(cc.computeArea());
			
		}
    
	}

}