package com.beerworld.beer.service;

import java.util.List;

import com.beerworld.beer.dao.*;
import com.beerworld.beer.model.Beer;
import com.beerworld.beer.model.DistributionCenter;

public interface BeerService {
	
	public List<Beer> getAllBeers();
	
	public  String saveBeer(Beer beer); 
	
	public void deleteBeer(Long id);
	
	public Beer getBeerByID(Long id);
	
}
 