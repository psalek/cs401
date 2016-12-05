package edu.mum.cs.cs401.examples.java8.streams1;

import java.util.List;
import java.util.OptionalDouble;

import edu.mum.cs.cs401.examples.java8.pojos.City;
import edu.mum.cs.cs401.examples.java8.utils.TopCities;

/**
 * Uses Stream API to calculate the average population of top 50 US cities.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class CityPopulation7 {

	public static void main(String[] args) {
		List<City> topCities = TopCities.getTopCities();
		
		OptionalDouble averagePopulation = topCities
				.stream()
				.peek(System.out::println)
				.mapToInt(c -> c.getPopulation())
				.average();
		
		System.out.printf("\nAverage population of top 50 US cities is %,.0f", averagePopulation.getAsDouble());
		
		OptionalDouble averagePopulationChange = topCities
				.stream()
				.mapToDouble(c -> c.getPopulationChange())
				.average();
		
		System.out.printf("\nAverage population change in top 50 US cities is %.2f percent", averagePopulationChange.getAsDouble());
	}
}
