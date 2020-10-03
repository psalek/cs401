package lesson2.lecture.manytomany;

import java.util.*;

/**
 * Design decisions:
 *  1. Student is immutable (relative to its package) -- we do not
 *  allow clients to modify Student id or name. 
 *  2. Assigning this student to a Section is done through
 *  the factory. TranscriptEntries
 *  for this student are updated through the factory, not here.
 *
 */
public class Student {
	////////package level elements, used by the factory
	Student() {
		//do nothing
	}
	String id;
	String name;
	List<TranscriptEntry> grades = new ArrayList<>();
	
	void setId(String id) {
		this.id = id;
	}
	
	void setName(String name) {
		this.name = name;
	}

	//////////////////
	
	
	public Transcript getTranscript() {
		return new Transcript(transcriptEntriesWithAssignedGrades());
		
	}
	
	private List<TranscriptEntry> transcriptEntriesWithAssignedGrades() {
		List<TranscriptEntry> list = new ArrayList<>();
		for(TranscriptEntry te: grades) {
			if(te.getGrade() != null) {
				list.add(te);
			}
		}
		return list;
	}
	
	public void setGrade(Section section, String grade) {
		StudentSectionFactory.newTranscriptEntry(this,section,grade);
	}
	
	public void addSection(Section sect) {
		StudentSectionFactory.addSectionForStudent(this, sect);
	}
	
	public String getId() {
		return id;
	}

	
	public String getName() {
		return name;
	}

	

	public List<TranscriptEntry> getGrades() {
		return grades;
	}

	//package level
	void setGrades(List<TranscriptEntry> grades) {
		this.grades = grades;
	}

	@Override
	public boolean equals(Object ob) {
		if(ob == null) return false;
		if(!(ob instanceof Student)) return false;
		Student s = (Student)ob;
		return s.id.equals(id);
	}
	
}
