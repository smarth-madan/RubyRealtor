package org.springframework.social.showcase.mlsListing.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.mlsListing.helper.MlsListingHelper;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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


	@RequestMapping(value="/addTagsToProperty")
	public ModelAndView addTagsToProperty(HttpServletRequest request, HttpServletResponse response) {

		String mlsId = request.getParameter("mls_id");
		System.out.println("mls_id"+mlsId);
		List<Property> propertyList = mlsListingHelper.getIndividualPropertyDetails(mlsId);
		System.out.println("Property Tgas:"+propertyList.get(0).getMLS_ID());
		ModelAndView mv = new ModelAndView();
		if(propertyList!=null)
		{
			mv.addObject("propertyList", propertyList);
		}

		mv.setViewName("realtor/addTagsToProperty");
		return mv;

	}

	@RequestMapping(value="/addTag")
	public ModelAndView addTag(HttpServletRequest request, HttpServletResponse response) {

		String tag1 = request.getParameter("tag1");
		String tag2 = request.getParameter("tag2");
		String tag3 = request.getParameter("tag3");
		String tag4 = request.getParameter("tag4");
		String tag5 = request.getParameter("tag5");
		String ownTag = request.getParameter("ownTag");
		String mlsId = request.getParameter("mls_id");
		List<Property> propertyList = mlsListingHelper.getIndividualPropertyDetails(mlsId);
		String existingTags = "";
		if(propertyList!=null){
			existingTags = propertyList.get(0).getTags();
		}
		StringBuffer tagString = getCompleteTagString(tag1, tag2, tag3, tag4, tag5, ownTag, existingTags);
		System.out.println("tagString = "+tagString.toString());
		boolean result = mlsListingHelper.addTags(tagString.toString(), mlsId);
		if(result){
			propertyList = mlsListingHelper.getIndividualPropertyDetails(mlsId);
		}
		ModelAndView mv = new ModelAndView();
		if(propertyList!=null)
		{
			mv.addObject("propertyList", propertyList);
			mv.addObject("result", "*** Tags have been added. Check the 'Existing tags' section.");
		}
		else{
			mv.addObject("result", "*** Tags could not be added. Try again later.");
		}
		mv.setViewName("realtor/addTagsToProperty");
		return mv;

	}
	
	@RequestMapping(value="/editTags")
	public ModelAndView editTag(HttpServletRequest request, HttpServletResponse response) {

		String mlsId = request.getParameter("mls_id");
		String tagString = request.getParameter("editTags");
		List<Property> propertyList = new ArrayList<Property>();
		
		boolean result = mlsListingHelper.addTags(tagString.toString(), mlsId);
		if(result){
			propertyList = mlsListingHelper.getIndividualPropertyDetails(mlsId);
		}
		ModelAndView mv = new ModelAndView();
		if(propertyList!=null)
		{
			mv.addObject("propertyList", propertyList);
			mv.addObject("result", "*** Tags have been edited. Check the 'Existing tags' section.");
		}
		else{
			mv.addObject("result", "*** Tags could not be edited. Try again later.");
		}
		mv.setViewName("realtor/addTagsToProperty");
		return mv;

	}

	private StringBuffer  getCompleteTagString(String tag1,String tag2,String tag3,String tag4,String tag5,String ownTag,String existingTags){
		if(existingTags == null)
			existingTags = "";
		StringBuffer tagString = new StringBuffer(existingTags);
		if (tag1!=null && !"".equals(tag1)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(tag1);

		}
		if (tag2!=null && !"".equals(tag2)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(tag2);

		}
		if (tag3!=null && !"".equals(tag3)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(tag3);
		}
		if (tag4!=null && !"".equals(tag4)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(tag4);
		}
		if (tag5!=null && !"".equals(tag5)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(tag5);
		}
		if (ownTag!=null && !"".equals(ownTag)){
			if(!"".equals(tagString) && tagString.length()!=0)
			{
				tagString.append(", ");
			}
			tagString.append(ownTag);

		}
		
		return tagString;
	}

}
