package edu.mum.cs.cs401.examples.java8.streams1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import edu.mum.cs.cs401.examples.java8.pojos.City;
import edu.mum.cs.cs401.examples.java8.utils.TopCities;

/**
 * Uses Stream API to filter top US cities in the state of North Carolina.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class CityPopulation8 {

	public static void main(String[] args) {
		List<City> topCities = TopCities.getTopCities();
		
		System.out.println("\nPrinting list of most populated cities in the state of North Carolina...");
		
		Stream<City> stream = topCities
				.stream()
				.filter(c -> "NC".equals(c.getState()))
				.sorted(TopCities::comparePopulationHigh2Low);
		
		List<City> topCitiesNC = stream.collect(Collectors.toList());
		
		topCitiesNC.forEach(System.out::println); // Note that List has a "forEach" method too!
		
		// TopCities.printCities(topCitiesNC);
	}
}
