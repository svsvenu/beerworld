package com.beerworld.beer.util;

import java.util.ArrayList;

import org.hibernate.*;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import com.beerworld.beer.model.*;

public class HibernateUtil {
	
	private static SessionFactory factory;
	
	public static Configuration getIntializedConfiguration(){
		
		AnnotationConfiguration config = new AnnotationConfiguration();
		
		config.addAnnotatedClass(Address.class);
		config.addAnnotatedClass(Brewery.class);
		config.addAnnotatedClass(DistributionCenter.class);
		config.addAnnotatedClass(Beer.class);

		
		config.configure();
		return config;
		
	}
	
	public static Session getSession(){
		
		if ( factory == null) {
			Configuration config = HibernateUtil.getIntializedConfiguration();
			factory = config.buildSessionFactory();
		}
		
		Session hibernateSession = factory.getCurrentSession();
		return hibernateSession;
	}
	
public static void closeSession(){
		
		HibernateUtil.getSession().close();
}

public static void recreateDatabase(){
	
	Configuration config;
	config = getIntializedConfiguration();
	new SchemaExport(config).create(true,true);
}

public static Session beginTransaction() {
	
	Session hibernateSession;
	hibernateSession = HibernateUtil.getSession();
	hibernateSession.beginTransaction();
	return hibernateSession;
	
}

public static void commitTransaction(){
	
	HibernateUtil.getSession().getTransaction().commit();
}

public static void rollbackTransaction(){
	
	HibernateUtil.getSession().getTransaction().rollback();
}

public static void main (String[] args){
	
	recreateDatabase();
	
	Brewery br = new Brewery();
	
	Address ad = new Address();
	ad.setAddress1("address1");
	ad.setAddress2("address2");
	ad.setCity("city");
	ad.setCountry("usa");
	ad.setZip("75025");
	
	
	DistributionCenter dc = new DistributionCenter();
	dc.setAddress(ad);
	dc.setBrewery(br);
	ArrayList<DistributionCenter> distributionCenters = new ArrayList<DistributionCenter>();
	distributionCenters.add(dc);
	
	Beer beer = new Beer ();
	beer.setAlcoholPercentage(3.14f);
	beer.setIsLightBeer(true);
	beer.setBrewery(br);
	beer.setName("budweiser");
	
	ArrayList<Beer> beers = new ArrayList<Beer>();
	beers.add(beer);
	
	br.setBeers(beers);
	br.setDistributionCenters(distributionCenters);
	br.setBreweryName("Anheiser Busch");
	br.setName("Anheiser Busch");
	
	Session sess = getSession();
	
	sess.beginTransaction();
	
//	sess.persist(ad);
	sess.persist(br);
	
	sess.getTransaction().commit();

	
	
}

}
