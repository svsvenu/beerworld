package com.beerworld.beer.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MacroBrewsController {

	@RequestMapping(value="/recipes")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("recipes");
	}
}
