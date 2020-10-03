package lesson7.lecture.singletoninherit.java8;

public enum OneOfAKind implements House {
	INSTANCE;
	private static final int ONE_OF_A_KIND_INDEX = 1000;
	private int age;
	private int numBedrooms;
	@Override
	public int computePopularityIndex() {
		return ONE_OF_A_KIND_INDEX;
	}
	@Override
	public int getNumBedrooms() {
		return numBedrooms;
	}
	@Override
	public void setNumBedrooms(int numBedrooms) {
		this.numBedrooms = numBedrooms;
		
	}
	@Override
	public int getAge() {
		return age;
	}
	@Override
	public void setAge(int age) {
		this.age = age;
		
	}
	
	
}
