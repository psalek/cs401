package lesson2.lecture.manytomany;

import java.util.*;

public class StudentSectionFactory {
	private static List<Student> students = new ArrayList<>(); 
	private static List<Section> sections = new ArrayList<>();
	
	/**
	 * Creates a new Section with empty gradeSheet if it doesn't already exist. 
	 * Section is added
	 * to list of Sections that is maintained in this factory
	 */
	public static Section createSection(int secNum, String courseName) {
		Section section = findSection(secNum);
		if(section == null) {
			section = new Section();
			section.sectionNumber = secNum;
			section.courseName = courseName;
			sections.add(section);
		}
		return section;
	}
	
	/**
	 * Creates a new Student with empty grades list if it doesn't already exist. Student is added
	 * to list of Students that is maintained in this factory.
	 */
	public static Student createStudent(String id, String name) {
		Student st = findStudent(id);
		if(st == null) {
			st = new Student();
			st.id = id;
			st.name = name;
			students.add(st);
		}
		return st;
	}
		
	/**
	 * Used to assign a grade to a Student for a particular Section. 
	 * There are three scenarios:
	 * 1. A transcript entry for this student and section does not yet
	 * exist. In that case, a new one is created and the grade is
	 * inserted. The new transcript entry is added to the list of transcript
	 * entries belonging to the student and also to the section
	 * 2. A transcript entry already exists because it was added using
	 * a method to add a section for a student or to add a student to a section.
	 * In those cases, no grade has yet been assigned. In this case, a
	 * new transcript entry is not created, but the grade is inserted.
	 * 3. A transcript entry with this student and section already exists
	 * because a grade was already assigned; in this case, the grade is updated.
	 * 
	 * Note: if we do not forbid duplicate transcript entries, inconsistencies
	 * could arise. For instance, a student in a section could be assigned
	 * a grade and then later, by accident, a student could be added to the same
	 * section later on. It is possible in this case that, in searching
	 * for the grade for the student in that section, the transcript entry
	 * for this student/section that does not have a grade is the one that is found,
	 * and so it would appear that no grade was assigned. Another scenario
	 * would be that a grade for a student/section is assigned, but then later
	 * a new transcript entry might be created to change the grade. The result
	 * would be two transcript entries with the same student and section but with
	 * different grades.
	 */
	public static void newTranscriptEntry(
			Student s, Section sect, String grade) {
		//if TranscriptEntry does not exist, create one
		TranscriptEntry te = null;
		if((te = findTranscriptEntry(s, sect)) == null) {
			te = new TranscriptEntry();
			te.setStudent(s);
			te.setSection(sect);
			s.getGrades().add(te);
			sect.getGradeSheet().add(te);
		}
		//in any case, update this TranscriptEntry with a grade
		//note te is not null in this case since it was retrieved
		//in the if clause
		te.setGrade(grade);
		
	}
	
	public static List<Student> getStudents() {
		return Collections.unmodifiableList(students);
	}
	public static List<Section> getSections() {
		return Collections.unmodifiableList(sections);
	}
	
	/**
	 * Returns true if the student with specified id can
	 * be found in the list of students maintained here
	 */
	public static boolean studentExists(String id) {
		return (findStudent(id) != null);
	}
	
	/**
	 * Returns true if the section with specified section number can
	 * be found in the list of sections maintained here
	 */
	public static boolean sectionExists(int sectionNum) {
		return (findSection(sectionNum) != null);
	}
	
	/**
	 * Adds (existing) Student to (existing) Section by creating
	 * a new TranscriptEntry for this pair. If this TranscriptEntry
	 * already exists, it is not created again. (Note that in this 
	 * case, the Student was already assigned to that section.)
	 */
	public static void addStudentToSection(Section section, Student s) {
		//If this transcript entry already exists, don't create it again
		if(findTranscriptEntry(s, section) == null) {
			TranscriptEntry te = new TranscriptEntry();
			te.student = s;
			te.section = section;
			section.gradeSheet.add(te);
			s.grades.add(te);
		}
	}
	
	/**
	 * Adds (existing) Section to (existing) Student's list of sections by creating
	 * a new TranscriptEntry for this pair. If this TranscriptEntry
	 * already exists, it is not created again. (Note that in this 
	 * case, the Section was already in the Student's list of sections.)
	 */
	public static void addSectionForStudent(Student student, Section s) {
		//If this transcript entry already exists, don't create it again
		if(findTranscriptEntry(student, s) == null) {		
			TranscriptEntry te = new TranscriptEntry();
			te.student = student;
			te.section = s;
			student.grades.add(te);
			s.gradeSheet.add(te);
		}
		
	}
	public static TranscriptEntry findTranscriptEntry(Student st, Section sect) {
		for(TranscriptEntry te: st.getGrades()) {
			if(te.getSection().equals(sect)) {
				return te;
			}
		}
		return null;
	}
	public static Student findStudent(String id) {
		for(Student s: students) {
			if(s.id.equals(id)) {
				return s;
			}
		}
		return null;
	}
	public static Section findSection(int secNum) {
		for(Section s: sections) {
			if(s.sectionNumber == secNum) {
				return s;
			}
		}
		return null;
	}
	
}
