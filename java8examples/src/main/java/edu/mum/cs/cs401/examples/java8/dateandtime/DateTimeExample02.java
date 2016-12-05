package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;
import java.time.YearMonth;
import java.time.temporal.TemporalAdjusters;

/**
 * Simple examples from Date-Time packages: LocalDate, YearMonth, MonthDay and Year
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample02 {

	public static void main(String[] args) {
		// LocalDate
		System.out.println(LocalDate.now()); // Today's date
		
		LocalDate date = LocalDate.of(2000, Month.NOVEMBER, 40); // Throws java.time.DateTimeException for invalid values

		DayOfWeek dow = date.getDayOfWeek();
		
		LocalDate nextWed = date.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
		
		System.out.printf("For the date of %s, day of week is %s and the next Wednesday is %s.%n%n", date, dow, nextWed);
		
		// YearMonth
		YearMonth date1 = YearMonth.now();
		System.out.printf("YearMonth = %s, Length of Month = %d%n", date1, date1.lengthOfMonth());

		YearMonth date2 = YearMonth.of(2010, Month.FEBRUARY);
		System.out.printf("YearMonth = %s, Length of Month = %d%n", date2, date2.lengthOfMonth());

		YearMonth date3 = YearMonth.of(2012, Month.FEBRUARY);
		System.out.printf("YearMonth = %s, Length of Month = %d%n", date3, date3.lengthOfMonth());
		
		// MonthDay
		MonthDay monthDay = MonthDay.of(Month.FEBRUARY, 29);
		
		boolean isMonthDayValidInYear = monthDay.isValidYear(2010);
		System.out.printf("%nIs February 29 a valid date in 2010? %s%n", isMonthDayValidInYear);
		
		// Year
		boolean validLeapYear = Year.of(2012).isLeap();
		System.out.printf("%nWas 2012 a leap year? %s%n", validLeapYear);
	}
}
