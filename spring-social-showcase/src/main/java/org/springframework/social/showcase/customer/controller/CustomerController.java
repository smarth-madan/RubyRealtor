package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"customerId","customers"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static CustomerHelper customerHelper;
	
	@Autowired
	private SessionRealtor sessionRealtor;
	
	@Inject
	public CustomerController(DataSource mysqldataSource) {
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
		inputModel.setR_ID(String.valueOf((sessionRealtor.getRealtorId())));
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
			Boolean success = customerHelper.updateCustomer(customerId,newCustomerReqId);
			if(success){
				mv.setViewName("home/home");
			}
			else{
				mv.setViewName("error/error");
				mv.addObject("error", "Sorry, Customer Requirement could not be added due to internal error!!!");
			}
		}
		else{
			mv.setViewName("error/error");
			mv.addObject("error", "Sorry, Customer Requirement could not be added due to internal error!!!");
			//TODO: Remove the customer also.
		}
		
		return mv;
	}
	
	@RequestMapping(value="/edit" , method=RequestMethod.POST)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("c_id") String c_id, @ModelAttribute("customers") List<Customer> customers){
		ModelAndView mv = new ModelAndView();
		for (Customer customer : customers){
			if(c_id.equalsIgnoreCase(customer.getC_id())){
				mv.addObject("customer", customer);
				mv.setViewName("customer/editCustomer");
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/editSubmit" , method=RequestMethod.POST)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("input") Customer customer){
		ModelAndView mv = new ModelAndView();
		Boolean success = customerHelper.editCustomer(customer);
		if(success){
			mv.setViewName("home/home");
		}
		return mv;	
	}
	
	
	
}
