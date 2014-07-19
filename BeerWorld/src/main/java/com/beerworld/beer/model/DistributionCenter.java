package com.beerworld.beer.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name="com.beerworld.beer.model.DistributionCenter")
@Table(name="distributioncenter")
public class DistributionCenter {
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private Long id;
	
	private String distributionCenterName;
	
	private Long addressID;
	
	@ManyToOne
	@JoinColumn(name="brewery_id")
	private Brewery brewery;
	
	private Address address;
	
	@OneToOne(fetch=FetchType.EAGER ,cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	@ManyToOne
	@JoinColumn(name="brewery_id")
	public Brewery getBrewery() {
		return brewery;
	}
	
	@ManyToOne
	@JoinColumn(name="brewery_id")
	public void setBrewery(Brewery brewery) {
		this.brewery = brewery;
	}
	public String getDistributionCenterName() {
		return distributionCenterName;
	}
	public void setDistributionCenterName(String distributionCenterName) {
		this.distributionCenterName = distributionCenterName;
	}
	
	public Long getAddressID() {
		return addressID;
	}
	public void setAddressID(Long addressID) {
		this.addressID = addressID;
	}
	
	public String toString() {
		
		return id + ":" + distributionCenterName;
	}

}
