package lesson7.lecture.singletoninherit.java8;

public interface House {
	
	abstract public int computePopularityIndex();
	
	public default double computeApproxDownpayment() {
		return (1-getAge()/100.0) * getNumBedrooms() * 25000;
	}
	public int getNumBedrooms();
	public void setNumBedrooms(int numBedrooms);
	public int getAge(); 
	public void setAge(int age);
	
}
