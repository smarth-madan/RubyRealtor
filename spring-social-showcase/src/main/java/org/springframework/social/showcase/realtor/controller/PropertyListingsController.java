package org.springframework.social.showcase.realtor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.showcase.realtor.model.Customer;
import org.springframework.social.showcase.realtor.model.Property;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertyListingsController {
	private String BASE_URL = "http://localhost:8081";
	
	@RequestMapping("/properties")
	public String home(Model model) {
		Property property1 = new Property();
		property1.setName("Gateway Apartments");
		property1.setAddress("148 E. william Street Apt#21 San Jose, CA 95112");
		property1.setRating("3.5");
		property1.setImage(BASE_URL+"/property1.gif");
		
		Property property2 = new Property();
		property2.setName("Colonade Apartments");
		property2.setAddress("148 E. william Street Apt#21 San Jose, CA 95112");
		property2.setRating("4.5");
		property2.setImage(BASE_URL+"/property2.jpg");
		
		List<Property> propertyList = new ArrayList<Property>();
		propertyList.add(property1);
		propertyList.add(property2);
		model.addAttribute("propertyList", propertyList);
		//return "home";
		return "realtor/PropertyList";
	}

}
