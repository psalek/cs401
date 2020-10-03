package lesson2.lecture.manytomany;

public class TranscriptEntry {
	Student student;
	Section section;
	String grade;
	
	public Student getStudent() {
		return student;
	}

	void setStudent(Student student) {
		this.student = student;
	}

	public Section getSection() {
		return section;
	}

	void setSection(Section section) {
		this.section = section;
	}

	public String getGrade() {
		return grade;
	}

	void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof TranscriptEntry)) return false;
		TranscriptEntry te = (TranscriptEntry)ob;
		return (student.equals(te.student)  && section.equals(te.section));
	}
	@Override
	public String toString() {
		return "Student: " + student.name + "\n"
				+ "Course name: " + section.courseName + "\n"
				+ "Section number: " + section.sectionNumber + "\n"
				+ "Grade: " + grade + "\n";
	}
}
