package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;

/**
 * Simple examples from Date-Time packages: LocalTime and LocalDateTime
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample03 {

	public static void main(String[] args) throws InterruptedException {
		
		//LocalTime
		LocalTime now;
		int counter = 0;
		while (counter++ < 5) {
		    now = LocalTime.now();
		    System.out.printf("%02d:%02d:%02d%n", now.getHour(), now.getMinute(), now.getSecond());
		    Thread.sleep(1000);
		}
		
		// LocalDateTime
		System.out.printf("%nnow: %s%n%n", 
				LocalDateTime.now());

		System.out.printf("Apr 15, 1994 @ 11:30am: %s seconds part is: %d%n%n", 
				LocalDateTime.of(1994, Month.APRIL, 15, 11, 30), LocalDateTime.of(1994, Month.APRIL, 15, 11, 30).getSecond());

		System.out.printf("now (from Instant - Local Zone): %s%n%n",
				LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault()));

		System.out.printf("now (from Instant - Paris): %s%n%n",
				LocalDateTime.ofInstant(Instant.now(), ZoneId.of("Europe/Paris")));

		System.out.printf("6 months from now: %s%n%n",
				LocalDateTime.now().plusMonths(6));

		System.out.printf("6 months ago: %s%n%n",
				LocalDateTime.now().minusMonths(6));
	}
}
