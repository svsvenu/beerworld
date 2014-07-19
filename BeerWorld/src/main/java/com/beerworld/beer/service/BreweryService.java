package com.beerworld.beer.service;

import java.util.List;

import com.beerworld.beer.dao.*;
import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.model.DistributionCenter;

public interface BreweryService {
	
	public List<Brewery> getRecentBrewaries(int pageCount);
	
	public List<Brewery> getAllBrewaries();
	
	public  String saveBrewery(Brewery brewery); 
	
	public void deleteBrewery(Long id);
	
	public Brewery getBreweryByID(Long id);
	
	public DistributionCenter getDistributionCenterByID(Long id);
}
 