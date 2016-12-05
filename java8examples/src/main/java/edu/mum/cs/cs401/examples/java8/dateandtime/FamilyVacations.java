package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.Month;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class FamilyVacations implements TemporalQuery<Boolean> {

	// Returns true if the passed-in date occurs during one of the
	// family vacations. Because the query compares the month and day only,
	// the check succeeds even if the Temporal types are not the same.
	public Boolean queryFrom(TemporalAccessor date) {
	    int month = date.get(ChronoField.MONTH_OF_YEAR);
	    int day   = date.get(ChronoField.DAY_OF_MONTH);

	    // Disneyland over Spring Break
	    if ((month == Month.APRIL.getValue()) && ((day >= 3) && (day <= 8)))
	        return Boolean.TRUE;

	    // Smith family reunion on Lake Saugatuck
	    if ((month == Month.AUGUST.getValue()) && ((day >= 8) && (day <= 14)))
	        return Boolean.TRUE;

	    return Boolean.FALSE;
	}
}
