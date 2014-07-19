package com.beerworld.beer.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.NotEmpty;


@Entity(name="com.beerworld.beer.model.Brewery")
@Table(name="brewery")
@EntityListeners(com.beerworld.beer.util.BeerInterceptor.class)
public class Brewery {
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	private Long id;
	
	@Size(min=2, max=30)
	private String name;
	
	@OneToMany(mappedBy="brewery",cascade=CascadeType.ALL,targetEntity=Beer.class,fetch=FetchType.EAGER)
	private List<DistributionCenter> distributionCenters;
	
	private List<Beer> beers ;
	
	@OneToMany(mappedBy="brewery",cascade=CascadeType.ALL,targetEntity=Beer.class,fetch=FetchType.EAGER)
	public List<Beer> getBeers() {
		return beers;
	}
	
	@OneToMany(mappedBy="brewery",cascade=CascadeType.ALL,targetEntity=Beer.class,fetch=FetchType.EAGER)
	public void setBeers(List<Beer> beers) {
		this.beers = beers;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	public void setBreweryName(String name) {
		this.name = name;
	}
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(mappedBy="brewery",cascade=CascadeType.ALL,targetEntity=DistributionCenter.class)
	public List<DistributionCenter> getDistributionCenters() {
		return distributionCenters;
	}
	
	@OneToMany(mappedBy="brewery",cascade=CascadeType.ALL,targetEntity=DistributionCenter.class)
	public void setDistributionCenters(List<DistributionCenter> distributionCenters) {
		this.distributionCenters = distributionCenters;
	}
	
	public String toString() {
		
		return "id: " + id + "name: " + name;
	}

}
