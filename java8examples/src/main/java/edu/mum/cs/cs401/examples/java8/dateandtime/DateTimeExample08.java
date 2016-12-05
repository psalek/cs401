package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Simple examples from Date-Time packages: Parsing and Formatting
 * 
 * For more info, please see 
 * <a href=http://docs.oracle.com/javase/8/docs/api/java/time/format/DateTimeFormatter.html#patterns>DateTimeFormatter Patterns</a>
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample08 {

	public static void main(String[] args) throws InterruptedException {
		// Parsing
		String input = "Aug 15 1984";
		try {
		    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d yyyy");
		    LocalDate date = LocalDate.parse(input, formatter);
		    System.out.printf("%s%n", date);
		}
		catch (DateTimeParseException e) {
		    System.out.printf("%s is not parsable!%n", input);
		    throw e;      // Rethrow the exception.
		}
		// 'date' has been successfully parsed
		
		// Formatting
		ZoneId leavingZone = ZoneId.of("Europe/Paris");
		ZonedDateTime departure = ZonedDateTime.now(leavingZone);

		try {
		    DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM d yyyy  hh:mm a");
		    String out = departure.format(format);
		    System.out.printf("LEAVING:  %s (%s)%n", out, leavingZone);
		}
		catch (DateTimeException exc) {
		    System.out.printf("%s can't be formatted!%n", departure);
		    throw exc;
		}
	}
}
