package com.beerworld.beer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="com.beerworld.beer.model.Beer")
@Table(name="beer")
public class Beer {
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private Long 	id;
	
	private String 	name;
	
	private Boolean isLightBeer;

	private Float 	alcoholPercentage;

	private Brewery brewery;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getIsLightBeer() {
		return isLightBeer;
	}
	public void setIsLightBeer(Boolean isLightBeer) {
		this.isLightBeer = isLightBeer;
	}
	public Float getAlcoholPercentage() {
		return alcoholPercentage;
	}
	public void setAlcoholPercentage(Float alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}
		
	@ManyToOne
	@JoinColumn(name="brewery_id")
	public Brewery getBrewery() {
		return brewery;
	}

	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}

}
