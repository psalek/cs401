package lesson7.lecture.singletoninherit.usual;

abstract public class House {
	private int numBedrooms;
	private int age;
	abstract public int computePopularityIndex();
	
	public House(int numBeds, int age) {
		this.numBedrooms = numBeds;
		this.age = age;
	}
	
	public double computeApproxDownpayment() {
		return (1-age/100.0) * numBedrooms * 25000;
	}
	public int getNumBedrooms() {
		return numBedrooms;
	}
	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
