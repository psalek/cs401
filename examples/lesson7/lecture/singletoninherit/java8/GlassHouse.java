package lesson7.lecture.singletoninherit.java8;

public class GlassHouse implements House {
	int numSquareFeet;
	private int numBedrooms;
	private int age;
	public GlassHouse(int numBeds, int age, int numSquareFeet) {
		this.numBedrooms = numBeds;
		this.age = age;
		this.numSquareFeet = numSquareFeet;
	}
	@Override
	public int computePopularityIndex() {
		return numSquareFeet/100 + age;
	}
	@Override
	public int getAge() {
		return age;
	}

	@Override
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int getNumBedrooms() {
		return numBedrooms;
	}

	@Override
	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
		
	}
}
