package lesson11.labs.prob6;

public class Account {
	private int acctId;
	private double balance;
	
	public Account(int id, double startBalance) {
		if(startBalance <= 0) throw new IllegalArgumentException("Start balance must be > 0!");
		acctId = id;
		balance = startBalance;
	}
	public int getAcctId() {
		return acctId;
	}
	public double getBalance() {
		return balance;
	}
	 
}
