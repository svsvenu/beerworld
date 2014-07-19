package com.beerworld.beer.service;

import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.beerworld.beer.dao.BeerDAO;
import com.beerworld.beer.dao.DistributionCenterDAO;
import com.beerworld.beer.model.Beer;
import com.beerworld.beer.model.DistributionCenter;

@Component
public class BeerServiceImpl implements BeerService {

	private BeerDAO beerDAO;
	
	@Inject
	public BeerServiceImpl(BeerDAO beerDAO){
		
		this.beerDAO = beerDAO;
	}
	
	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public String saveBeer(Beer beer) {
		// TODO Auto-generated method stubo[]\
		beerDAO.save(beer);
		
		return null;
	}

	@Override
	public List<Beer> getAllBeers() {
		return 	beerDAO.findAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW,readOnly=false)
	public void deleteBeer(Long id ) {
		beerDAO.delete(beerDAO.findByPrimaryKey((Long)id));		
	}

	
	@Override
	public Beer getBeerByID(Long id) {
		// TODO Auto-generated method stub
		return beerDAO.findByPrimaryKey(id);
	}
	
}


