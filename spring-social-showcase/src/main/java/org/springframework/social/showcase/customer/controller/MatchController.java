package org.springframework.social.showcase.customer.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.customer.helper.CustomerHelper;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.social.showcase.solr.SolrHelper;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"propertyList"})
@RequestMapping("/customer")
public class MatchController {

	private static CustomerHelper customerHelper;
	private static SolrHelper solrHelper;
	
	@Inject
	public MatchController(DataSource mysqldataSource) {
		customerHelper = new CustomerHelper(mysqldataSource);
		solrHelper = new SolrHelper(mysqldataSource);
	}
	
	@RequestMapping(value="/match",  method=RequestMethod.POST)
	public ModelAndView matchCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("input")Customer customer){
		
		CRequirements cRequirements = customerHelper.getCustomerReq(customer).get(0);
		
		List<Property> propertyList = solrHelper.searchListing(cRequirements);
				
		ModelAndView mv = new ModelAndView();
		mv.addObject("propertyList", propertyList);
		mv.setViewName("customer/matchResult");
		return mv;
	}
}
