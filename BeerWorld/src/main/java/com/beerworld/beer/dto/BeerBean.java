package com.beerworld.beer.dto;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;;

public class BeerBean {

	public Long breweryId() {
		return breweryId;
	}
	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
	}
	
	private Long 	breweryId;
	
	@Size(min=2, max=30)
	private String 	name;
	
	private Boolean isLightBeer;

	@Digits(integer=6, fraction=2)
	private Float 	alcoholPercentage;

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
	public Long getBreweryId() {
		return breweryId;
	}
	public void setAlcoholPercentage(Float alcoholPercentage) {
		this.alcoholPercentage = alcoholPercentage;
	}
		
	
}
