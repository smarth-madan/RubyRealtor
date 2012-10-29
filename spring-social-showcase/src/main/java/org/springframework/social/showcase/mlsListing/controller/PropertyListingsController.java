package org.springframework.social.showcase.mlsListing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.social.showcase.mlsListing.helper.MlsListingHelper;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.social.showcase.myProfile.helper.MyProfileHelper;
import org.springframework.social.showcase.realtor.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PropertyListingsController {
	
	private DataSource mysqldataSource;
	private static MlsListingHelper mlsListingHelper;

	@Inject
	public PropertyListingsController(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		mlsListingHelper = new MlsListingHelper(mysqldataSource);
	}
	@RequestMapping("/properties")
	public ModelAndView home(Model model) {
		
		
		List<Property> propertyList = mlsListingHelper.getPropertyDetails();
		
		ModelAndView mv = new ModelAndView();
		System.out.println("Image="+propertyList.get(0).getImageName());
		if(propertyList!=null)
		{
			mv.addObject("propertyList", propertyList);
		}
		mv.setViewName("realtor/PropertyList");
		return mv;
				
	}

}
