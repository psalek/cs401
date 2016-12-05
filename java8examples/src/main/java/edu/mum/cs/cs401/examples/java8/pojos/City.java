package edu.mum.cs.cs401.examples.java8.pojos;

/**
 * This is a POJO that encapsulates City info.
 * 
 * @author Salek, Payman
 * @since 1.0
 *
 */
public class City {
	private String name;
	private String state;
	
	private Integer population;
	private Integer population2012;
	private Integer population2010;
	private Integer population2005;
	private Integer population2000;
	private Integer population1990;
	
	private Double populationChange;
	
	private Integer rank;
	private Integer rank2012;
	private Integer rank2010;
	private Integer rank2000;
	private Integer rank1990;
	
	public void adjust() {
		population = population2012;
		rank = rank2012;
		if(null == populationChange) {
			populationChange = 0.0;
		}
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPopulation() {
		return population;
	}
	public void setPopulation(Integer population) {
		this.population = population;
	}
	public Integer getPopulation2012() {
		return population2012;
	}
	public void setPopulation2012(Integer population2012) {
		this.population2012 = population2012;
	}
	public Integer getPopulation2010() {
		return population2010;
	}
	public void setPopulation2010(Integer population2010) {
		this.population2010 = population2010;
	}
	public Integer getPopulation2005() {
		return population2005;
	}
	public void setPopulation2005(Integer population2005) {
		this.population2005 = population2005;
	}
	public Integer getPopulation2000() {
		return population2000;
	}
	public void setPopulation2000(Integer population2000) {
		this.population2000 = population2000;
	}
	public Integer getPopulation1990() {
		return population1990;
	}
	public void setPopulation1990(Integer population1990) {
		this.population1990 = population1990;
	}
	public Double getPopulationChange() {
		return populationChange;
	}
	public void setPopulationChange(Double populationChange) {
		this.populationChange = populationChange;
	}
	public Integer getRank() {
		return rank;
	}
	public void setRank(Integer rank) {
		this.rank = rank;
	}
	public Integer getRank2012() {
		return rank2012;
	}
	public void setRank2012(Integer rank2012) {
		this.rank2012 = rank2012;
	}
	public Integer getRank2010() {
		return rank2010;
	}
	public void setRank2010(Integer rank2010) {
		this.rank2010 = rank2010;
	}
	public Integer getRank2000() {
		return rank2000;
	}
	public void setRank2000(Integer rank2000) {
		this.rank2000 = rank2000;
	}
	public Integer getRank1990() {
		return rank1990;
	}
	public void setRank1990(Integer rank1990) {
		this.rank1990 = rank1990;
	}
	
	private static final String CITY_FORMATTER = "City: %-20s State: %2s Population: %,9d Rank: %02d Population Change (1990-2012): %05.2f";
	
	@Override
	public String toString() {
		return String.format(CITY_FORMATTER,
				name, state, population, rank, populationChange);
	}
}
