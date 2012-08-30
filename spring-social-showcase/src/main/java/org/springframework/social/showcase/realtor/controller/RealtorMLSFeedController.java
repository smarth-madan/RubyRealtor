package org.springframework.social.showcase.realtor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.social.sowcase.realtor.model.MLSFeed;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RealtorMLSFeedController {

	@RequestMapping("/mlsfeeds")
	public String home(Model model) {
		MLSFeed mlsFeed = new MLSFeed();
		mlsFeed.setId("1");
		mlsFeed.setUrl("http://www.google.com/");
		MLSFeed mlsFeed2 = new MLSFeed();
		mlsFeed2.setId("2");
		mlsFeed2.setUrl("http://www.yahoo.com/");
		List<MLSFeed> mlsFeeds = new ArrayList<MLSFeed>();
		mlsFeeds.add(mlsFeed);
		mlsFeeds.add(mlsFeed2);
		model.addAttribute("MLSFeeds", mlsFeeds);
		//return "home";
		return "realtor/MLSFeed";
	}
	
}
