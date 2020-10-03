package lesson2.lecture.manytomany;
import java.util.*;

/**
 * This class is just a wrapper for a list of TranscriptEntries
 */
public class Transcript {
	private List<TranscriptEntry> entries = new ArrayList<>();
	
	Transcript(List<TranscriptEntry> entries) {
		this.entries = entries;
	}
	
	/** Formatted report */
	public String toString()  {
		if(entries.isEmpty()) return "No data";
		StringBuilder sb = new StringBuilder("Transcript for ");
		Student student = entries.get(0).student;
		sb.append(student.name + ": ");
		sb.append("\n\n");
		int len = "Course Name          Grade".length();
		sb.append(" Section Number    Course Name          Grade\n");
		for(TranscriptEntry te : entries) {
			sb.append(sp(5) + te.section.sectionNumber    
					+ sp(15) + te.section.courseName 
					+ sp(len - te.section.courseName.length()-6) + te.grade);
			sb.append("\n");
		}
		return sb.toString();			
		
	}
	
	private String sp(int k) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < k; ++i) {
			sb.append(" ");
		}
		return sb.toString();
	}
}
