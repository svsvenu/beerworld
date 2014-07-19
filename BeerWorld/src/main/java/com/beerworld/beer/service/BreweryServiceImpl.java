package com.beerworld.beer.service;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.beerworld.beer.dao.BreweryDAO;
import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.model.DistributionCenter;

@Component
public class BreweryServiceImpl implements BreweryService {

	private BreweryDAO breweryDAO;
	
	@Inject
	public BreweryServiceImpl(BreweryDAO breweryDAO){
		
		this.breweryDAO = breweryDAO;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public List<Brewery> getRecentBrewaries(int pageCount) { 
		
		ArrayList<Brewery> breweries = new ArrayList<Brewery>();
		breweries.add(breweryDAO.findByPrimaryKey(1L)) ;
		return breweries;
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public String saveBrewery(Brewery brewery) {
		// TODO Auto-generated method stubo[]\
	;
	
		breweryDAO.save(brewery);
		return null;
	}

	@Override
	public List<Brewery> getAllBrewaries() {
		return 	breweryDAO.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void deleteBrewery(Long id ) {
		breweryDAO.delete(breweryDAO.findByPrimaryKey((Long)id));		
	}

	@Override
	public Brewery getBreweryByID(Long id) {
		// TODO Auto-generated method stub
		
		return breweryDAO.findByPrimaryKey(id);
		
	}

	@Override
	public DistributionCenter getDistributionCenterByID(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}


