package org.springframework.social.showcase.realtor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.sowcase.realtor.model.MLSFeed;
import org.springframework.social.sowcase.realtor.model.MyProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyProfileController {

	@RequestMapping("/myprofile")
	public String home(Model model) {
		MyProfile myProfile = new MyProfile();
		myProfile.setFname("John");
		myProfile.setLname("Doe");
		myProfile.setEmailId("john.doe@mail.com");
		myProfile.setAddress("148, E. William St.,Apt#21,San Jose, CA 95112");
		myProfile.setRealtorId("R0012345");
		model.addAttribute("myProfile", myProfile);
		//return "home";
		return "realtor/MyProfile";
	}
}
