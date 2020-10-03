package lesson11.labs.prob6;

public class CheckingAccount extends Account {
	final double PENALTY = 10.00;
	public CheckingAccount(int id, double startBalance) {
		super(id, startBalance);
	}
	
	@Override
	public double getBalance() {
		return super.getBalance() - PENALTY;
	}
}
