package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Simple examples from Date-Time packages: Legacy Date-Time Code
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample13 {

	public static void main(String[] args) throws InterruptedException {
		// Legacy Date-Time Code
		Calendar calendar = Calendar.getInstance();
		System.out.println(LocalDateTime.ofInstant(calendar.toInstant(), ZoneId.systemDefault()));
		
		Date date = calendar.getTime();
		System.out.println(LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()));
		
		Date newDate = Date.from(calendar.toInstant());
		System.out.println(newDate);
		
		GregorianCalendar cal = new GregorianCalendar();

		System.out.println(cal.getTimeZone());
		System.out.println(cal.get(Calendar.ZONE_OFFSET));

		ZonedDateTime zdt = cal.toZonedDateTime();

		System.out.println(GregorianCalendar.from(zdt));

		System.out.println(zdt.toLocalDateTime());
		System.out.println(zdt.toLocalDate());
		System.out.println(zdt.toLocalTime());
		
	}
}
