package org.springframework.social.showcase.facebook;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.showcase.mlsListing.helper.MlsListingHelper;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookPostPropertyController {

	private static MlsListingHelper mlsListingHelper;
	private String pageId;
	private String albumId;
	private final Facebook facebook;

	Properties properties = new Properties();

	@Inject
	public FacebookPostPropertyController(Facebook facebook, DataSource mysqldataSource) {
		this.facebook = facebook;
		mlsListingHelper = new MlsListingHelper(mysqldataSource);
	}

	@RequestMapping(value="/postProperty", method=RequestMethod.POST)
	public ModelAndView postProperty(HttpServletRequest request, HttpServletResponse response) {
		String mlsId = request.getParameter("mls_id");
		List<Property> propertyList = mlsListingHelper.getIndividualPropertyDetails(mlsId);

		ModelAndView mv = new ModelAndView();
		if(propertyList!=null)
		{
			mv.addObject("propertyList", propertyList);
		}
		mv.setViewName("realtor/PostPropertyToFB");
		return mv;
	}

	@RequestMapping(value="/postPropertyToFaceBook", method=RequestMethod.POST)
	public ModelAndView postPropertyToFB(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") Property inputModel) {
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("org/springframework/social/showcase/config/application.properties"));    	    
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("property file application.properties " 
					+ "' not found in the classpath");
		}
		String mlsId = request.getParameter("size");
		String imagePath = request.getParameter("image");
		String description = request.getParameter("description");
		String size = request.getParameter("size");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zipcode = request.getParameter("zipcode");
		String price = request.getParameter("price");
		String type = request.getParameter("type");
		String parking = request.getParameter("parking");
		String bed_bath = request.getParameter("bed_bath");
		String garage = request.getParameter("garage");
		
		String caption = description + "Size: " +size +"Address: "+ street +", "+city +", "+state +"-"+zipcode +", Price:"+price+", House type:"+type+", Bed/Bath"+bed_bath+", Parking:"+parking+", Garage:"+garage;
		this.pageId = properties.getProperty("awesomeRealtor.pageId");
		this.albumId = properties.getProperty("awesomeRealtor.pageId");
		
		Resource resource = new FileSystemResource(imagePath);
		facebook.pageOperations().postPhoto(pageId, albumId, resource, caption);
		System.out.println(mlsId);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("realtor/PostPropertyToFB");
		return mv;
	}

}
