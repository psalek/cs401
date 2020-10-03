package lesson5.lecture.factorymethods6.otherpackage;

public class DataRecord {
	String id;
	String name;
	String grade;
	public DataRecord(String id, String name, String grade) {
		this.id = id;
		this.name = name;
		this.grade = grade;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getGrade() {
		return grade;
	}
}
