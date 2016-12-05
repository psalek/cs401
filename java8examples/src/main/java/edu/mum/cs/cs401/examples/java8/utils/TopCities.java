package edu.mum.cs.cs401.examples.java8.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.mum.cs.cs401.examples.java8.pojos.City;

/**
 * This class acts as a simple DAO to load the list of top 50 US cities.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class TopCities {

	/**
	 * Returns the list of top 50 US cities. 
	 * Note: It shuffles the list before returning it to the calling app.
	 *
	 */
	public static List<City> getTopCities() {
		List<City> topCities = null;
		
		try {
			topCities = loadTopCities();
			Collections.shuffle(topCities);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return topCities;
	}
	
	/**
	 * Prints the list of cities passed in as a parameter to console.
	 *  
	 */
	public static void printCities(List<City> cities) {
		System.out.println();
		for(City c : cities) {
			System.out.println(c);
		}
	}
	
	/**
	 * compares two cities and returns:
	 * 
	 * 1) Zero, if they have the same population
	 * 2) A negative integer, if c2 has a bigger population than c1
	 * 3) A positive integer, if c1 has a bigger population than c2
	 *  
	 */
	public static int comparePopulationHigh2Low(City c1, City c2) {
		return c2.getPopulation() - c1.getPopulation();
	}
	
	/**
	 * 
	 *	Private helper methods
	 * 
	 */	
	private static List<City> loadTopCities() throws Exception {
		System.out.print("Loading the list of top 50 US cities...");

		FileReader reader = new FileReader("./src/main/resources/Cities.csv");
		BufferedReader br = new BufferedReader(reader);
		
		List<City> topCities = new ArrayList<City>(50);

		String line = null;
		while((line = br.readLine()) != null) {
			City city =  convertCSVLine2City(line);
			topCities.add(city);
			System.out.print(".");
			Thread.sleep(100);
		}

		br.close();
		
		System.out.println("\nFinished loading the list of top 50 US cities");		
		Thread.sleep(1000);

		return topCities;
	}
	
	private static City convertCSVLine2City(String line) {
		String[] tokens = line.split(",");
		
		City city = new City();
		
		city.setName(tokens[0].trim());
		city.setState(tokens[1].trim());
		
		city.setPopulation2012(convertToInteger(tokens[2]));
		city.setPopulation2010(convertToInteger(tokens[3]));
		city.setPopulation2005(convertToInteger(tokens[4]));
		city.setPopulation2000(convertToInteger(tokens[5]));
		city.setPopulation1990(convertToInteger(tokens[6]));
		
		city.setPopulationChange(convertToDouble(tokens[7]));

		city.setRank1990(convertToInteger(tokens[8]));
		city.setRank2000(convertToInteger(tokens[9]));
		city.setRank2010(convertToInteger(tokens[10]));
		city.setRank2012(convertToInteger(tokens[11]));
		
		city.adjust();

		return city;
	}
	
	private static Integer convertToInteger(String value) {
		if(null == value) {
			return null;
		}
		
		value = value.trim();
		if(value.equals("")) {
			return null;
		}
		
		return Integer.valueOf(value);
	}

	private static Double convertToDouble(String value) {
		if(null == value) {
			return null;
		}
		
		value = value.trim();
		if(value.equals("")) {
			return null;
		}
		
		return Double.valueOf(value);
	}

}
