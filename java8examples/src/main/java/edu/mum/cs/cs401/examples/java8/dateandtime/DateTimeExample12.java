package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * Simple examples from Date-Time packages: Period and Duration
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample12 {

	public static void main(String[] args) throws InterruptedException {
		// Duration
		Instant t1, t2;
		t1 = Instant.now();
		t2 = t1.plus(Duration.ofSeconds(10));
		System.out.printf(
				"Duration between t1 and t2 in nanoseconds is: %,d %n",
				Duration.between(t1, t2).toNanos());

		// ChronoUnit
		System.out.printf(
				"Gap between t1 and t2 in ChronoUnit.MILLIS is: %,d %n",
				ChronoUnit.MILLIS.between(t1, t2));

		// Period
		LocalDate today = LocalDate.now();
		
		LocalDate birthday = LocalDate.of(1960, Month.JANUARY, 1);
		Period period1 = Period.between(birthday, today);
		long days1 = ChronoUnit.DAYS.between(birthday, today);
		System.out.println("You are " + period1.getYears() + " years, "
				+ period1.getMonths() + " months, and " + period1.getDays()
				+ " days old. (" + days1 + " days total)");

		LocalDate nextBDay = birthday.withYear(today.getYear());

		// If your birthday has occurred this year already, add 1 to the year.
		if (nextBDay.isBefore(today) || nextBDay.isEqual(today)) {
			nextBDay = nextBDay.plusYears(1);
		}

		Period period2 = Period.between(today, nextBDay);
		long days2 = ChronoUnit.DAYS.between(today, nextBDay);
		System.out.println("There are " + period2.getMonths() + " months, and "
				+ period2.getDays() + " days until your next birthday. ("
				+ days2 + " days total)");
	}
}
