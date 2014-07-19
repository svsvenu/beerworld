package com.beerworld.beer.dto;


public class AddressBean {
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private Long id;
	
	private String address1;
	
	private String address2;

	private String city;

	private String state;
	
	private String country;
	
	private String zip;
	
	private Long distributionCenterID;

	public Long getDistributionCenterID() {
		return distributionCenterID;
	}
	public void setDistributionCenterID(Long distributionCenterID) {
		this.distributionCenterID = distributionCenterID;
	}
	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}
