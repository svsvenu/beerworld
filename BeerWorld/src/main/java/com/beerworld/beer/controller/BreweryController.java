package com.beerworld.beer.controller;

import java.io.IOException;
import java.util.HashMap;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beerworld.beer.dto.AddressBean;
import com.beerworld.beer.dto.BeerBean;
import com.beerworld.beer.dto.DistributionBean;
import com.beerworld.beer.model.Address;
import com.beerworld.beer.model.Beer;
import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.model.DistributionCenter;
import com.beerworld.beer.service.*;

@Controller
public class BreweryController {   
	
	private BreweryService breweryService ; 
	

	@Inject
	public BreweryController(BreweryService breweryServcie){
		
		this.breweryService = breweryServcie;
	}
	
	@RequestMapping(value="/brewery", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView brewery() {
      return new ModelAndView("brewery", "command", new Brewery() ); 
	   }
 	
	@RequestMapping(value="/addBrewery", method={RequestMethod.POST,RequestMethod.GET})
	public String addDrewery(@ModelAttribute("command") @Valid Brewery brewery, BindingResult result,
			   ModelMap model) {
		
		if (result.hasErrors()){
			
			return "brewery";
			
		}
		
		breweryService.saveBrewery(brewery);
			
	    return "redirect:/"; 
	    
	   }
	
	@RequestMapping(value="/deleteBrewery", method=RequestMethod.GET)
	public String addDrewery(@RequestParam("id") Long id, 
			   ModelMap model) {
		
		breweryService.deleteBrewery(id);
		
		return "redirect:/"; 
		
	   }
	
	@RequestMapping(value="/editBrewery", method=RequestMethod.GET)
	public ModelAndView editBrewery(@RequestParam("id") Long id, HttpServletResponse response) throws IOException{
		
		Brewery brewery = breweryService.getBreweryByID(id);  
		
		ModelAndView mv = new ModelAndView("editbrewery");
		
		System.out.println("dist centers are " + brewery.getDistributionCenters());
		
		mv.addObject("brewery", brewery);
		
		return mv;
	}
	
	@RequestMapping(value="/distributioncenter", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView distributionCenter(@RequestParam("id") Long id) {
		
		DistributionBean dc = new DistributionBean();
		
		ModelAndView mv = new ModelAndView("distribution", "command1", dc ); 
		
		HashMap<String,String> hm = new HashMap<String, String>();
		
		hm.put("id",id.toString());
		
		hm.put("breweryName",breweryService.getBreweryByID(id).getName());
		
		mv.addObject("id", hm);

		return mv;
	   }
	
	@RequestMapping(value="/adddistributioncenter", method={RequestMethod.POST,RequestMethod.GET})
	public String addDDistributionCenter( @ModelAttribute("command") @Valid DistributionBean distributionCenter, BindingResult result,
			   ModelMap model ) {
		
		
		Brewery brewery = breweryService.getBreweryByID(distributionCenter.getBreweryId());
		
		DistributionCenter dc = new DistributionCenter();
		
		dc.setDistributionCenterName(distributionCenter.getDistributionCenterName()) ;
		
		brewery.getDistributionCenters().add(dc);
		
		dc.setBrewery(brewery);
		
			
		breweryService.saveBrewery(brewery);
		
		System.out.println("saved");
		
	    return "redirect:/editBrewery?id=" + distributionCenter.getBreweryId() ; 
	    
	   }
	
	@RequestMapping(value="/beers", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView beers(@RequestParam("id") Long id) {
		
		Brewery brewery = breweryService.getBreweryByID(id);  
		
		ModelAndView mv = new ModelAndView("beers");
		
		mv.addObject("brewery", brewery);
		
		return mv;
		
	   }
	
	
	@RequestMapping(value="/addbeer", method={RequestMethod.POST,RequestMethod.GET})
	public ModelAndView addBeer(@RequestParam("id") Long id) {
		
		BeerBean bb = new BeerBean();
		
		ModelAndView mv = new ModelAndView("beer", "command", bb ); 
		
		HashMap<String,String> hm = new HashMap<String, String>();
		
		hm.put("id",id.toString());
		
		hm.put("breweryName",breweryService.getBreweryByID(id).getName());
		
		mv.addObject("id", hm);

		return mv;
	   }
	
	@RequestMapping(value="/savebeer", method={RequestMethod.POST,RequestMethod.GET})
	public String saveBeer( @ModelAttribute("command") @Valid BeerBean beerBean, BindingResult result,
			   ModelMap model ) {
		
		if (result.hasErrors()){
			
			return "beer"  ;
			
		}
		
		Brewery brewery = breweryService.getBreweryByID(beerBean.getBreweryId());
		
		Beer beer = new Beer();
		
		beer.setAlcoholPercentage(beerBean.getAlcoholPercentage());
		beer.setBrewery(brewery);
		beer.setIsLightBeer(beerBean.getIsLightBeer());
		beer.setName(beerBean.getName());
		
		brewery.getBeers().add(beer);
		
		breweryService.saveBrewery(brewery);
		
		return "redirect:/beers?id=" + beerBean.getBreweryId() ;
	}
	
	@RequestMapping(value = "/header", method = RequestMethod.GET)
	   public String redirect() {
	     
	      return "common/header"; 
	   }
	
	
}
