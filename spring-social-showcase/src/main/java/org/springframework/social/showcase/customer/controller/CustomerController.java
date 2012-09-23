package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

//@SessionAttributes({"form"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private DataSource mysqldataSource;
	
	@Inject
	public CustomerController(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		CustomerHelper customerHelper = new CustomerHelper(mysqldataSource);
		List<Customer> customers = customerHelper.findAllCustomers();
		mv.addObject("customers",customers);
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
