package edu.mum.cs.cs401.examples.java8.lambdas;

import java.util.Collections;
import java.util.List;

import edu.mum.cs.cs401.examples.java8.pojos.City;
import edu.mum.cs.cs401.examples.java8.utils.TopCities;

/**
 * Uses a lambda expression + utility method call to sort the list of cities.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class CityPopulation4 {

	public static void main(String[] args) {
		List<City> topCities = TopCities.getTopCities();
		
		Collections.sort(topCities, (c1, c2) -> TopCities.comparePopulationHigh2Low(c1, c2));
		
		TopCities.printCities(topCities);
	}
}
