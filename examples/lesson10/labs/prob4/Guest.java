package lesson10.labs.prob4;

public class Guest {
	private String name;
	private Status status;
	private Gender gender;
	private int numYearsKnown;
	private boolean planningToCome;
	public Guest(String name, Status status, Gender gender, int numYearsKnown, boolean willAttend) {
		this.name = name;
		this.status = status;
		this.gender = gender;
		this.numYearsKnown = numYearsKnown;
		this.planningToCome = willAttend;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getNumYearsKnown() {
		return numYearsKnown;
	}
	public void setNumYearsKnown(int numYearsKnown) {
		this.numYearsKnown = numYearsKnown;
	}
	public boolean isPlanningToCome() {
		return planningToCome;
	}
	public void setPlanningToCome(boolean planningToCome) {
		this.planningToCome = planningToCome;
	}
	
}
