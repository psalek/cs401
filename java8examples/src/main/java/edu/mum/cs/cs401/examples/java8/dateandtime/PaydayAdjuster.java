package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PaydayAdjuster implements TemporalAdjuster {

	/**
	 * The adjustInto method accepts a Temporal instance 
	 * and returns an adjusted LocalDate. If the passed in
	 * parameter is not a LocalDate, then a DateTimeException is thrown.
	 */
	public Temporal adjustInto(Temporal input) {
	    LocalDate date = LocalDate.from(input);
	    int day;
	    if (date.getDayOfMonth() < 15) {
	        day = 15;
	    } else {
	        day = date.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
	    }
	    date = date.withDayOfMonth(day);
	    if (date.getDayOfWeek() == DayOfWeek.SATURDAY ||
	        date.getDayOfWeek() == DayOfWeek.SUNDAY) {
	        date = date.with(TemporalAdjusters.previous(DayOfWeek.FRIDAY));
	    }

	    return input.with(date);
	}
	
}
