package lesson5.lecture.factorymethods5.triangle.otherpackage;
import java.util.Arrays;

import lesson5.lecture.factorymethods5.triangle.*;
public class Main {

	public static void main(String[] args) {
		Triangle myTriangle = Triangle.fromThreeSides(1, 1, 1);
		System.out.println(Arrays.toString(myTriangle.getAngles(myTriangle)));		
	}

}
