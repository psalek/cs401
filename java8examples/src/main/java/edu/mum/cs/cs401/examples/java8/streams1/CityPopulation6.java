package edu.mum.cs.cs401.examples.java8.streams1;

import java.util.Comparator;
import java.util.List;

import edu.mum.cs.cs401.examples.java8.pojos.City;
import edu.mum.cs.cs401.examples.java8.utils.TopCities;

/**
 * Uses Stream API to sort the list of cities.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class CityPopulation6 {

	public static void main(String[] args) {
		List<City> topCities = TopCities.getTopCities();
		
		topCities.stream().sorted(TopCities::comparePopulationHigh2Low).forEach(System.out::println);
		
		// This is equivalent to:
		topCities.stream()
				.sorted((c1, c2) -> TopCities.comparePopulationHigh2Low(c1, c2))
				.forEach(c -> System.out.println(c));

		// Also equivalent to:
		topCities.stream().sorted(				
				new Comparator<City>() {
					public int compare(City c1, City c2) {
						// Reverse of natural order, from high to low
						return c2.getPopulation() - c1.getPopulation();
					}
				}
			).forEach(System.out::println);
	}
}
