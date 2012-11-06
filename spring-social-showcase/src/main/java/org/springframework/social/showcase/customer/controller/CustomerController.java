package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.customer.helper.CustomerHelper;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.customer.model.FBCustomer;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.social.showcase.solr.SolrHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"customerId","customers","propertyList"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static CustomerHelper customerHelper;
	private static SolrHelper solrHelper;
	
	@Autowired
	private SessionRealtor sessionRealtor;
	
	@Inject
	public CustomerController(DataSource mysqldataSource) {
		customerHelper = new CustomerHelper(mysqldataSource);
		solrHelper = new SolrHelper(mysqldataSource);
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
	
	@RequestMapping(value="/registerFromFB", method=RequestMethod.POST)
	public ModelAndView registerFromFB(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") FBCustomer inputModel) {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("numberofPersons="+inputModel.getNumber_of_persons());
		
		inputModel.setR_ID(String.valueOf((sessionRealtor.getRealtorId())));
		inputModel.setR_ID("1");
		inputModel.setCustomer_priority("1");
		int newCustomerId = customerHelper.addFBCustomer(inputModel);
		if(newCustomerId >=0 ){
			System.out.println("newCustomerId=="+newCustomerId);
			int result = customerHelper.addFBCustomerReq(inputModel, newCustomerId);
			if(result!=-1){
			mv.addObject("result", "Thank you. Your profile has been created, the Real estate Agent will be in touch with you soon");
			mv.setViewName("realtor/result");
			}
			else{
				mv.setViewName("realtor/result");
				mv.addObject("result", "Sorry, Customer could not be added due to internal error!!!");
			}
		}
		else{
			mv.setViewName("realtor/result");
			mv.addObject("result", "Sorry, Customer could not be added due to internal error!!!");
		}
		mv.setViewName("realtor/result");
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
				mv.setViewName("realtor/result");
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
			mv.setViewName("realtor/result");
			mv.addObject("result", "Customer data updated Successfully.");
		}
		return mv;	
	}
	
	@RequestMapping(value="/match",  method=RequestMethod.POST)
	public ModelAndView matchCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("input")Customer customer){
		
		CRequirements cRequirements = customerHelper.getCustomerReq(customer).get(0);
		
		List<Property> propertyList = solrHelper.searchListing(cRequirements);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("propertyList", propertyList);
		mv.setViewName("customer/matchResult");
		//mv.setViewName("realtor/PropertyList");
		return mv;
	}

	
	@RequestMapping(value="/emailPropertyList",  method=RequestMethod.POST)
	public ModelAndView matchCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("propertyList")List<Property> propertyList, @ModelAttribute("input")Customer customer){
		
		Customer eCustomer = customerHelper.getCustomer(customer.getC_id());
		
		//List<Property> propertyList = solrHelper.searchListing(cRequirements);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("propertyList", propertyList);
		//mv.setViewName("customer/matchResult");
		mv.setViewName("realtor/PropertyList");
		return mv;
	}
	
	
	
}
