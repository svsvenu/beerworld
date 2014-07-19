package com.beerworld.beer.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable > {

	T findByPrimaryKey (ID id);
	List<T> findAll ( );
//	List<T> findByExample ( T exampleInstance, String[] excludeProperty);
	T save (T entity);
	void delete (T entity);
	void beginTransaction();
	void endTransaction(); 
	

}
