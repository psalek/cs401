package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.temporal.TemporalAdjusters;

/**
 * Simple examples from Date-Time packages: OffsetDateTime
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample06 {

	public static void main(String[] args) throws InterruptedException {
		// Find the last Thursday in July 2013.
		LocalDateTime localDate = LocalDateTime.of(2013, Month.JULY, 20, 19, 30);
		ZoneOffset offset = ZoneOffset.of("-08:00");

		OffsetDateTime offsetDate = OffsetDateTime.of(localDate, offset);
		OffsetDateTime lastThursday = offsetDate.with(TemporalAdjusters.lastInMonth(DayOfWeek.THURSDAY));
		
		System.out.printf("The last Thursday in July 2013 is the %sth.%n", lastThursday.getDayOfMonth());
	}
}
