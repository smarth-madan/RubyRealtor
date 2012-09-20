package org.springframework.social.showcase.customer.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.addObject("feed","blah blah");
		mv.setViewName("customer/viewCustomer");
		return mv;
		
	}
	
	@RequestMapping("/add")
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.addObject("feed","blah blah");
		mv.setViewName("customer/addCustomer");
		return mv;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.addObject("feed","blah blah");
		mv.setViewName("customer/editCustomer");
		return mv;
		
	}
	
	
	
}
