package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * Simple examples from Date-Time packages: Instant Class
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample07 {

	public static void main(String[] args) throws InterruptedException {
		// Instant
		Instant timestamp = Instant.now();
		System.out.println(timestamp); // Zone will be Z or Zulu or Zero
		
		Instant oneHourLater = Instant.now().plusSeconds(3600); // Progress one hour
		System.out.println(oneHourLater);
		
		long secondsFromEpoch = Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.SECONDS);
		System.out.printf("Number of seconds from Epoch is: %,d%n", secondsFromEpoch);
		
		LocalDateTime ldt = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
		System.out.printf("%nValue of timestamp/instant in default timezone is:%n%s %d %d at %d:%d%n", ldt.getMonth(), ldt.getDayOfMonth(),
		                  ldt.getYear(), ldt.getHour(), ldt.getMinute());
	}
}
