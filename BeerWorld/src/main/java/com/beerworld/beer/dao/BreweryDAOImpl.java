package com.beerworld.beer.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import com.beerworld.beer.model.Brewery;

@Component
public class BreweryDAOImpl implements BreweryDAO {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Brewery findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Brewery.class, id);
	}

	@Override
	public List<Brewery> findAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(" from com.beerworld.beer.model.Brewery " ) ;
		return (List<Brewery> ) query.getResultList();
		
	}

	@Override 
	public Brewery save(Brewery entity) {

		entityManager.merge(entity);
		
		return entity;
	}

	@Override
	public void delete(Brewery entity) {
		
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
