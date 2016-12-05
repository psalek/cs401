package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

/**
 * Simple examples from Date-Time packages: The Temporal Package
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample10 {

	public static void main(String[] args) throws InterruptedException {
		// Predefined Adjusters
		LocalDate date = LocalDate.now();
		DayOfWeek dotw = date.getDayOfWeek();
		
		System.out.printf("%s is on a %s%n", date, dotw);

		System.out.printf("first day of Month: %s%n",
				date.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.printf("first Monday of Month: %s%n",
				date.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.printf("last day of Month: %s%n",
				date.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.printf("first day of next Month: %s%n",
				date.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.printf("first day of next Year: %s%n",
				date.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.printf("first day of Year: %s%n",
				date.with(TemporalAdjusters.firstDayOfYear()));

		// Custom Adjusters
		System.out.printf("%nnext payday (using a custom TemporalAdjuster): %s%n",
				date.with(new PaydayAdjuster()));
	}
}
