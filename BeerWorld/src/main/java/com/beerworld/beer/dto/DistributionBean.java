package com.beerworld.beer.dto;



public class DistributionBean {
	
	
	public Long getBreweryId() {
		return breweryId;
	}
	public void setBreweryId(Long breweryId) {
		this.breweryId = breweryId;
	}
	
	private Long breweryId;
	
	private String distributionCenterName;
	
	public String getDistributionCenterName() {
		return distributionCenterName;
	}
	public void setDistributionCenterName(String distributionCenterName) {
		this.distributionCenterName = distributionCenterName;
	}
	
	public String toString() {
		
		return breweryId + ":" + distributionCenterName;
	}

}
