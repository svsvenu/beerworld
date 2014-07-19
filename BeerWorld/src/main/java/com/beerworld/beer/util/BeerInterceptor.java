package com.beerworld.beer.util;

import javax.persistence.*;

public class BeerInterceptor {
		
	@PostLoad
	public void logBeforePersist(Object pc){
		
		System.out.println("************postLoad from interceptor ******************" + pc.toString()
				);
	}
	
	@PostPersist
	public void logAfterPersist(Object pc){
		
		System.out.println("************postpersist from interceptor ******************" + pc.toString()
				);
	}

}
