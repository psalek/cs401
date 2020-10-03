package lesson7.lecture.singletoninherit.usual;

public class GlassHouse extends House {
	int numSquareFeet;
	public GlassHouse(int numBeds, int age, int numSquareFeet) {
		super(numBeds, age);
		this.numSquareFeet = numSquareFeet;
	}
	@Override
	public int computePopularityIndex() {
		return numSquareFeet/100 + super.getAge();
	}
}
