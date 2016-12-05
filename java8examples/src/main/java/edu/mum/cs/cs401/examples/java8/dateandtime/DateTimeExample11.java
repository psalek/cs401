package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalQueries;
import java.time.temporal.TemporalQuery;
import java.time.temporal.TemporalUnit;

/**
 * Simple examples from Date-Time packages: Temporal Query
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample11 {

	public static void main(String[] args) throws InterruptedException {
		// Temporal Queries
		TemporalQuery<TemporalUnit> query = TemporalQueries.precision();
		System.out.printf("LocalDate precision is %s%n",
				LocalDate.now().query(query));
		System.out.printf("LocalDateTime precision is %s%n", 
				LocalDateTime.now().query(query));
		System.out.printf("Year precision is %s%n", 
				Year.now().query(query));
		System.out.printf("YearMonth precision is %s%n",
				YearMonth.now().query(query));
		System.out.printf("Instant precision is %s%n",
				Instant.now().query(query));

		// Custom Temporal Queries
		
		// Invoking the query without using a lambda expression.
		LocalDate date = LocalDate.now();
		Boolean isFamilyVacation = date.query(new FamilyVacations());

		// Invoking the query using a lambda expression.
		Boolean isFamilyBirthday = date.query(FamilyBirthdays::isFamilyBirthday);

		if (isFamilyVacation.booleanValue() || isFamilyBirthday.booleanValue())
			System.out.printf("%s is an important date!%n", date);
		else
			System.out.printf("%s is not an important date.%n", date);
	}
}
