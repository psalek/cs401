package lesson2.lecture.manytomany.extpackage;
import java.util.*;

import lesson2.lecture.manytomany.*;
public class Main {
	
	public static void main(String[] args) { 
		Main m = new Main();
		Student bob = StudentSectionFactory.createStudent("S1", "Bob");
		Student tim = StudentSectionFactory.createStudent("S2", "Tim");
		Student allen = StudentSectionFactory.createStudent("S3", "Allen");
		Section bio1 = StudentSectionFactory.createSection(1, "Biology");
		Section bio2 = StudentSectionFactory.createSection(2, "Biology");
		Section math = StudentSectionFactory.createSection(3, "Math");
		StudentSectionFactory.addSectionForStudent(bob, bio1);
		StudentSectionFactory.addSectionForStudent(bob, math);
		StudentSectionFactory.addSectionForStudent(tim, bio1);
		StudentSectionFactory.addSectionForStudent(tim, math);
		StudentSectionFactory.addSectionForStudent(allen, bio2);
		StudentSectionFactory.addSectionForStudent(allen, math);
		//set grades
		StudentSectionFactory.newTranscriptEntry(bob,bio1, "A");
		StudentSectionFactory.newTranscriptEntry(bob,math, "B");
		StudentSectionFactory.newTranscriptEntry(tim,bio1, "A-");
		StudentSectionFactory.newTranscriptEntry(tim,math, "B+");
		StudentSectionFactory.newTranscriptEntry(allen,bio2, "C");
		StudentSectionFactory.newTranscriptEntry(allen,math, "A");
		
		System.out.println(bob.getTranscript());
		System.out.println("Grades for math section:\n " + m.getGrades(math));
		System.out.println("Courses that Tim took: " + m.getCourseNames(tim));
		System.out.println("Students who got A's: " + m.getStudentsWith("A"));
		
		//change Bob's bio1 grade from A to B
		StudentSectionFactory.newTranscriptEntry(bob, bio1, "B");
		
		//list of "A" students has changed
		System.out.println("Students who got A's: " + m.getStudentsWith("A"));
	}
	
	private List<String> getGrades(Section s) {
		List<String> grades  = new ArrayList<>();
		for(TranscriptEntry t : s.getGradeSheet()) {
			grades.add(t.getGrade());
		}
		return grades;
	}
	private List<String> getCourseNames(Student s) {
		List<TranscriptEntry> all = s.getGrades();
		List<String> courseNames = new ArrayList<>();
		for(TranscriptEntry te : all) {
			courseNames.add(te.getSection().getCourseName());
		}
		return courseNames;
	}
	
	private List<String> getStudentsWith(String grade) {
		List<String> studentNames = new ArrayList<>();
		for(Student s : StudentSectionFactory.getStudents()) {
			boolean found = false;
			for(TranscriptEntry te : s.getGrades()) {
				if(!found) {
					if(te.getGrade().equals(grade)) {
						found = true;
						studentNames.add(s.getName());
					}
				}
			}
		}
		return studentNames;
	}
	

}
