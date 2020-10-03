package lesson3.labs.prob4;

public class House  {

	private double lotSize;
	
	
	public House(double lotSize) {
		this.lotSize = lotSize;
	}


	public double computeRent(){
		return 0.1 * lotSize;
	}
}
