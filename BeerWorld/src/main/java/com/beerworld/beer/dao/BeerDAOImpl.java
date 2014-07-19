package com.beerworld.beer.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.beerworld.beer.model.Beer;
import com.beerworld.beer.model.Brewery;

@Component
public class BeerDAOImpl implements BeerDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Beer findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Beer.class, id);
	}

	@Override
	public List<Beer> findAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(" from com.beerworld.beer.model.Beer " ) ;
		return (List<Beer> ) query.getResultList();
		
	}

	@Override 
	public Beer save(Beer entity) {

		entityManager.merge(entity);
		
		return entity;
	}

	@Override
	public void delete(Beer entity) {
		
		entityManager.remove(entity);
		
	}

	@Override
	public void beginTransaction() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTransaction() {
		// TODO Auto-generated method stub
		
	}

}
