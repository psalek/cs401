package lesson2.lecture.manytomany;

import java.util.*;

/**
 * Design decisions:
 *  1. Section is immutable (relative to its package) -- we do not
 *  allow clients to modify courseName or sectionNumber. And TranscriptEntries
 *  for this student are updated through the factory, not here.
 *
 */
public class Section {
	//package access constructor
	Section() {
		//do nothing 	
	}
	String courseName;
	int sectionNumber;
	List<TranscriptEntry> gradeSheet = new ArrayList<>();
	
	public void addStudent(Student student) {
		StudentSectionFactory.addStudentToSection(this, student);
	}
	
	public String getCourseName() {
		return courseName;
	}

	//package level
	void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getSectionNumber() {
		return sectionNumber;
	}

	//package level
	void setSectionNumber(int sectionNumber) {
		this.sectionNumber = sectionNumber;
	}

	public List<TranscriptEntry> getGradeSheet() {
		return gradeSheet;
	}
	
	//package level
	void setGradeSheet(List<TranscriptEntry> gradeSheet) {
		this.gradeSheet = gradeSheet;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Section)) return false;
		Section s = (Section)ob;
		return (s.sectionNumber == sectionNumber);
	}
}
