package lesson5.lecture.factorymethods6.studreport;

//Outside of the studreport package, GradeReport is immutable 
//Immutability depends on the fact that Student is also immutable
final public class GradeReport implements Comparable<GradeReport> {
	private Student student;
	private String grade;
	//package level access
	GradeReport(String grade) {
		this.grade = grade;
	}
	void setStudent(Student s) {
		student = s;
	}
	public Student getStudent() {
		return student;
	}
	public String getGrade() {
		return grade;
	}
	@Override
	public int compareTo(GradeReport o) {
		return grade.compareTo(o.grade);
	}
}
