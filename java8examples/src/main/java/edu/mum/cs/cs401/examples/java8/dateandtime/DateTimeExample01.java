package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 * Simple examples from Date-Time packages: DayOfWeek and Month Enums
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample01 {

	public static void main(String[] args) {
		
		//Locale locale = Locale.JAPAN;
		Locale locale = Locale.getDefault();

		// DayOfWeek
		System.out.printf("3 days after Monday is: %s%n", DayOfWeek.MONDAY.plus(3));
		
		DayOfWeek dow = DayOfWeek.MONDAY;
		System.out.println(dow);
		System.out.println(dow.getDisplayName(TextStyle.FULL, locale));
		System.out.println(dow.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(dow.getDisplayName(TextStyle.SHORT, locale));
		System.out.println();

		// Month
		System.out.printf("Max length of February is: %d%n", Month.FEBRUARY.maxLength());
		
		Month month = Month.AUGUST;
		System.out.println(month);
		System.out.println(month.getDisplayName(TextStyle.FULL, locale));
		System.out.println(month.getDisplayName(TextStyle.NARROW, locale));
		System.out.println(month.getDisplayName(TextStyle.SHORT, locale));
	}

}
