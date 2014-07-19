package com.beerworld.beer.controller;

import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.service.*;


// import com.beerworld.beer.service.*;

@Controller
public class HomeController {  
	
	private BreweryService breweryService ;
	
	@Inject
	public HomeController(BreweryService breweryServcie){
		
		this.breweryService = breweryServcie;
	}

	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		
	//	System.out.println("got here"); 
		
		List<Brewery> breweries = breweryService.getAllBrewaries();  
		
		ModelAndView mv = new ModelAndView("home");
		
		mv.addObject("breweries", breweries);
		
		response.addCookie(new Cookie ("name" ,  "value"));
		
		return mv;
	}
}
