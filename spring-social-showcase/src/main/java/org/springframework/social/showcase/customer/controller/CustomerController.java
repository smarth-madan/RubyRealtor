package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.customer.model.CustomerInputModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//@SessionAttributes({"form"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private DataSource mysqldataSource;
	private static CustomerHelper customerHelper;
	
	@Inject
	public CustomerController(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		customerHelper = new CustomerHelper(mysqldataSource);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<Customer> customers = customerHelper.findAllCustomers();
		mv.addObject("customers",customers);
		mv.setViewName("customer/viewCustomer");
		return mv;
		
	}
	
	@RequestMapping(value="/add",  method=RequestMethod.GET)
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.addObject("feed","blah blah");
		mv.setViewName("customer/addCustomer");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addCustomerSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") CustomerInputModel inputModel){
		ModelAndView mv = new ModelAndView();
		mv.addObject("feed","blah blah");
		mv.setViewName("customer/addSuccessfull");
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
