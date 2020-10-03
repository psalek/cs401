package lesson3.lecture.polymorphism2;

public class Secretary extends StaffPerson {
	private int yearsOfService;
	
	public int getYearsOfService() {
		return yearsOfService;
	}
	public void setYearsOfService(int years) {
		yearsOfService = years;
	}
	@Override
	public double computeStipend() {
		return 2500.0;
	}

}
