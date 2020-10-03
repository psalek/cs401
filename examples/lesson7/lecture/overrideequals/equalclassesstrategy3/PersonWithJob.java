package lesson7.lecture.overrideequals.equalclassesstrategy3;

/**
 * CORRECT: Same classes strategy for superclass and subclass.
 * Here, superclasses can be equal to each other and subclasses
 * equal to each other, but superclass and subclass are not compared.
 *  
 * If we wish Persons and PersonWithJobs always to be unequal, this
 * solution is good.
 *  
 * @author pcorazza
 *
 */
public class PersonWithJob extends Person {
	private double salary;
	PersonWithJob(String n, double s) {
		super(n);
		salary = s;
	}
	
	@Override
	public boolean equals(Object aPersonWithJob) {
		if(aPersonWithJob == null) return false; 
		if(aPersonWithJob.getClass() != this.getClass()) return false;
		PersonWithJob p = (PersonWithJob)aPersonWithJob;
		boolean isEqual = this.name.equals(p.name);
		return isEqual;
	}
	
	public static void main(String[] args) {
		Person p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new PersonWithJob("Joe", 30000);
		System.out.println("p1.equals(p2)? "+(p1.equals(p2)));
	}

}
