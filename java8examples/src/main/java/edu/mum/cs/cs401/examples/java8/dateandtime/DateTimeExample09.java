package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.IsoFields;

/**
 * Simple examples from Date-Time packages: ChronoUnit, ChronoField and IsoFields
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample09 {

	public static void main(String[] args) throws InterruptedException {
		// ChronoField and IsoFields
		LocalTime time = LocalTime.now();
		System.out.printf("LocalTime MILLI_OF_SECOND field is: %d%n", time.get(ChronoField.MILLI_OF_SECOND));

		LocalDate date = LocalDate.now();
		System.out.printf("LocalDate QUARTER_OF_YEAR field is: %d%n", date.get(IsoFields.QUARTER_OF_YEAR));

		// ChronoUnit enum - http://docs.oracle.com/javase/8/docs/api/java/time/temporal/ChronoUnit.html
		// Not all java.time classes support all ChronoUnit. If you can check what is supported, you can do the following:
		
		Instant now = Instant.now();
		boolean isSupported = false;
		
		isSupported = now.isSupported(ChronoUnit.DAYS);
		System.out.printf("ChronoUnit 'DAYS' is supported by 'Instant'? %b%n", isSupported);

		isSupported = now.isSupported(ChronoUnit.MONTHS);
		System.out.printf("ChronoUnit 'MONTHS' is supported by 'Instant'? %b%n", isSupported);
	}
}
