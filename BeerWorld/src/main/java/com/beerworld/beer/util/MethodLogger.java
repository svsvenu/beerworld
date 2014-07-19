package com.beerworld.beer.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Aspect
public class MethodLogger {
	
    @Before(" execution(* com.beerworld.beer.service.BreweryService.saveBrewery(..) ) ")
			
    		public void logMethod(JoinPoint joinpoint){
    	
    		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
   
			System.out.println("Intercepted save brewery modification made by " + auth.getName());
			
			}

}
