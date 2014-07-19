package com.beerworld.beer.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.model.DistributionCenter;

@Component
public class DistributionCenterDAOImpl implements DistributionCenterDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public DistributionCenter findByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return entityManager.find(DistributionCenter.class, id);
	}

	@Override
	public List<DistributionCenter> findAll() {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery(" from com.beerworld.beer.model.DistributionCenter " ) ;
		return (List<DistributionCenter> ) query.getResultList();
		
	}

	@Override 
	public DistributionCenter save(DistributionCenter entity) {

		entityManager.merge(entity);
		
		return entity;
	}

	@Override
	public void delete(DistributionCenter entity) {
		
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
