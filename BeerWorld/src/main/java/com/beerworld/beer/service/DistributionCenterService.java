package com.beerworld.beer.service;

import java.util.List;

import com.beerworld.beer.dao.*;
import com.beerworld.beer.model.DistributionCenter;

public interface DistributionCenterService {
	
	public List<DistributionCenter> getAllDistributionCenters();
	
	public  String saveDistributionCenter(DistributionCenter distributionCenter); 
	
	public void deleteDistributionCenter(Long id);
	
	public DistributionCenter getDistributionCenterByID(Long id);
	
}
 