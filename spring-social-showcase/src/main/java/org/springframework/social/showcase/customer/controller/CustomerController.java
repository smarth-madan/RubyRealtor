package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"customerId"})
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
		mv.setViewName("customer/addCustomer");
		return mv;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addCustomerSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") Customer inputModel){
		ModelAndView mv = new ModelAndView();
		int newCustomerId = customerHelper.addCustomer(inputModel);
		
		if(newCustomerId >=0 ){
			mv.addObject("customerId", newCustomerId);
			mv.setViewName("customer/addCustomerRequirements");
		}
		else{
			mv.setViewName("error/error");
			mv.addObject("error", "Sorry, Customer could not be added due to internal error!!!");
		}
		
		return mv;
	}
	
	@RequestMapping(value="/addReq", method=RequestMethod.POST)
	public ModelAndView addCustomerReqSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") CRequirements inputModel,@ModelAttribute("customerId") int customerId){
		ModelAndView mv = new ModelAndView();
		int newCustomerReqId = customerHelper.addCustomerReq(inputModel);
		
		if(newCustomerReqId >=0 ){
			mv.setViewName("customer/addCustomerRequirements");
			customerHelper.updateCustomer(customerId,newCustomerReqId);
		}
		else{
			mv.setViewName("error/error");
			mv.addObject("error", "Sorry, Customer Requirement could not be added due to internal error!!!");
			//TODO: Remove the customer also.
		}
		
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
