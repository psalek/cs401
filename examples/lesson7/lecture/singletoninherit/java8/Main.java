package lesson7.lecture.singletoninherit.java8;

public class Main {

	public static void main(String[] args) {
		House[] housesOnMyBlock = new House[4];
		housesOnMyBlock[0] = new AntiqueHome(4,40,20,20);
		housesOnMyBlock[1] = new AntiqueHome(3,30,15,25);
		housesOnMyBlock[2] = new GlassHouse(4,40,2500);
		OneOfAKind.INSTANCE.setAge(40);
		OneOfAKind.INSTANCE.setNumBedrooms(3);
		housesOnMyBlock[3] = OneOfAKind.INSTANCE;
		///average downpayment
		double downPaymentSum = 0;
		for(House h : housesOnMyBlock) {
			downPaymentSum += h.computeApproxDownpayment();
		}
		System.out.println("Average approximate downpayment for houses on my block: " + downPaymentSum/4);

	}

}
