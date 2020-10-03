package lesson7.lecture.singletoninherit.usual;

public class Main {

	public static void main(String[] args) {
		House[] housesOnMyBlock = new House[4];
		housesOnMyBlock[0] = new AntiqueHome(4,40,20,20);
		housesOnMyBlock[1] = new AntiqueHome(3,30,15,25);
		housesOnMyBlock[2] = new GlassHouse(4,40,2500);
		housesOnMyBlock[3] = new GlassHouse(3,10,3600);
		///average downpayment
		double downPaymentSum = 0;
		for(House h : housesOnMyBlock) {
			downPaymentSum += h.computeApproxDownpayment();
		}
		System.out.println("Average approximate downpayment for houses on my block: " 
		                    + downPaymentSum/4);

	}

}
