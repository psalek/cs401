package lesson7.lecture.overrideequals.instanceofstrategy2;

public class PersonWithJob extends Person {
	private double salary;
	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false; 
		if(!(ob instanceof PersonWithJob)) return false;
		PersonWithJob p = (PersonWithJob)ob;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	
	

}
