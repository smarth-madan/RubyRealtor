package org.springframework.social.showcase.myProfile.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.myProfile.helper.MyProfileHelper;
import org.springframework.social.showcase.myProfile.model.MyProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/myprofile")
public class MyProfileController {

	private DataSource mysqldataSource;
	private static MyProfileHelper myProfileHelper;

	@Inject
	public MyProfileController(DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		myProfileHelper = new MyProfileHelper(mysqldataSource);
	}
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home(Model model) {

		List<MyProfile> myProfileList = myProfileHelper.getRealtorDetails("bob.woolmer@gmail.com");
		ModelAndView mv = new ModelAndView();
		if(myProfileList!=null)
		{
			System.out.println("myprofile list not null");
			mv.addObject("myProfile", myProfileList.get(0));
		}
		System.out.println("myprofile list IS NULL....");
		mv.setViewName("realtor/MyProfile");
		return mv;
	}

	@RequestMapping(value="/edit",  method=RequestMethod.GET)
	public ModelAndView edit(HttpServletRequest request, HttpServletResponse response){

		List<MyProfile> myProfileList = myProfileHelper.getRealtorDetails("bob.woolmer@gmail.com");
		ModelAndView mv = new ModelAndView();
		if(myProfileList!=null)
		{
			System.out.println("myprofile list not null");
			mv.addObject("myProfile", myProfileList.get(0));
		}
		mv.setViewName("realtor/updateMyProfile");
		return mv;
	}

	
	@RequestMapping(value="/socialProfiles",  method=RequestMethod.GET)
	public ModelAndView socialProfiles(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mv = new ModelAndView();
		mv.setViewName("realtor/SocialProfiles");
		return mv;
	}
	
	@RequestMapping(value="/settings",  method=RequestMethod.GET)
	public ModelAndView settings(HttpServletRequest request, HttpServletResponse response){

		ModelAndView mv = new ModelAndView();
		mv.setViewName("realtor/Settings");
		return mv;
	}
	
	@RequestMapping(value="/update",  method=RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") MyProfile updatedProfile){

		boolean updateStatus = myProfileHelper.updateMyProfile(updatedProfile);
		ModelAndView mv = new ModelAndView();
		if(updateStatus)
		{
			mv.addObject("result", "Your personal Info as been Updated .");

		}
		else{
			mv.addObject("result", "Your personal Info could not be Updated. Please check back later.");
		}
		mv.setViewName("realtor/result");
		return mv;
	}
}
