package lesson7.lecture.singletoninherit.java8;

public class AntiqueHome implements House {
	private int numBedrooms;
	private int age;
	private int numAntiqueWindows;
	private int numOldMirrors;
	
	public AntiqueHome(int numBeds, int age, int numAntiqueWindows, int numOldMirrors) {
		this.numBedrooms = numBeds;
		this.age = age;
		this.numAntiqueWindows = numAntiqueWindows;
		this.numOldMirrors = numOldMirrors;
	}

	@Override
	public int computePopularityIndex() {
		return 2 * numAntiqueWindows + 3 * numOldMirrors;
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
