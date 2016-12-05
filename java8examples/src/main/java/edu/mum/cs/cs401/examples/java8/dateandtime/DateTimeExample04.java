package edu.mum.cs.cs401.examples.java8.dateandtime;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Simple examples from Date-Time packages: Time Zone and Offset
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class DateTimeExample04 {

	public static void main(String[] args) throws InterruptedException {
		
		//ZoneId and ZoneOffset
		Set<String> allZones = ZoneId.getAvailableZoneIds();

		LocalDateTime dateTime = LocalDateTime.now();

		// Create a List using the set of zones and sort it.
		List<String> zoneList = new ArrayList<String>(allZones);
		Collections.sort(zoneList);
		
		for(String zone : zoneList) {
			System.out.println(zone);
		}
		System.out.printf("There are a total of %d time zone Ids (time zone representations).%n", allZones.size());

		System.out.println("\nHere is a list of all time zones that do not have a whole hour:");
		for (String s : zoneList) {
		    ZoneId zone = ZoneId.of(s);
		    ZonedDateTime zonedDateTime = dateTime.atZone(zone);
		    ZoneOffset offset = zonedDateTime.getOffset();
		    int secondsOfHour = offset.getTotalSeconds() % (60 * 60);

		    // Write only time zones that do not have a whole hour offset to standard out
		    if (secondsOfHour != 0) {
		        System.out.printf("%35s %10s%n", zone, offset);
		    }
		}

	}
}
