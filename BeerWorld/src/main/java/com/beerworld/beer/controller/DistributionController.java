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
import com.beerworld.beer.dto.DistributionBean;
import com.beerworld.beer.model.Address;
import com.beerworld.beer.model.Brewery;
import com.beerworld.beer.model.DistributionCenter;
import com.beerworld.beer.service.*;

@Controller
public class DistributionController {   
	
	
	private DistributionCenterService distributionCenterService ; 

	@Inject
	public DistributionController(DistributionCenterService distributionCenterService){
		
		this.distributionCenterService = distributionCenterService;
	}
	
		
	@RequestMapping(value="/address", method=RequestMethod.GET)
	public ModelAndView editDistribution(@RequestParam("id") Long id ) throws IOException{
		
		DistributionCenter distributionCenter = distributionCenterService.getDistributionCenterByID(id);
		
		AddressBean 	ab = new AddressBean();
		
		ab.setDistributionCenterID(id);
		
		if (distributionCenter.getAddress() != null ) {
		
				ab.setAddress1(distributionCenter.getAddress().getAddress1());
				ab.setAddress2(distributionCenter.getAddress().getAddress2());
				ab.setCity(distributionCenter.getAddress().getCity());
				ab.setState(distributionCenter.getAddress().getState());
				ab.setZip(distributionCenter.getAddress().getZip());

	
		}
		
		
		
		ModelAndView 	mv = new ModelAndView("address", "command", ab ); 
		
	//	System.out.println("dist centers are " + distributionCenter.getDistributionCenters());
		
		mv.addObject("id", id);
		
		return mv;
	}
	
	@RequestMapping(value="/addaddress", method={RequestMethod.POST,RequestMethod.GET})
	public String addDAddress( @ModelAttribute("command") @Valid AddressBean addressBean, BindingResult result,
			   ModelMap model ) {
		
		
		DistributionCenter distributionCenter = distributionCenterService.getDistributionCenterByID(addressBean.getDistributionCenterID());
		
		Address ad = new Address();
		
		ad.setAddress1(addressBean.getAddress1());
		ad.setAddress2(addressBean.getAddress2());
		ad.setCity(addressBean.getCity());
		ad.setState(addressBean.getState());
		ad.setZip(addressBean.getZip());
		ad.setCountry(addressBean.getCountry());
		
		distributionCenter.setAddress(ad);
		
		distributionCenterService.saveDistributionCenter(distributionCenter);
		
	    return "redirect:/editBrewery?id=" + distributionCenter.getBrewery().getId() ; 
	    
	   }
	
	
	
}
