package org.springframework.social.showcase.facebook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.inject.Inject;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookPageController {

	private final Facebook facebook;
	Properties properties = new Properties();
	private String pageId;

	@Inject
	public FacebookPageController(Facebook facebook) {
		this.facebook = facebook;
	}
	
	@RequestMapping(value="/facebook/page", method=RequestMethod.GET)
	public String showFeed(Model model) {
		try {
			properties = PropertiesLoaderUtils.loadProperties(new ClassPathResource("org/springframework/social/showcase/config/application.properties"));    	    
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("property file application.properties " 
		            + "' not found in the classpath");
		}
		
	    this.pageId = properties.getProperty("awesomeRealtor.pageId");
		Page page = facebook.pageOperations().getPage(pageId);
		model.addAttribute("feed", facebook.feedOperations().getFeed(pageId));
		return "facebook/page";
	}
	
	@RequestMapping(value="/facebook/page", method=RequestMethod.POST)
	public String postUpdate(String message) {
		facebook.feedOperations().post(this.pageId,message);
		return "redirect:/facebook/page";
	}
	
	@RequestMapping(value="/facebook/pageEvent", method=RequestMethod.GET)
	public String createEvent() {
		return "facebook/pageEvent";
	}
	
	@RequestMapping(value="/facebook/pageEvent", method=RequestMethod.POST)
	public String postEvent(String name, String startTime) {
		MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
		data.set("name", name);
		data.set("start_time", startTime);
		//data.set("end_time", endTime);
		facebook.publish(this.pageId, "events", data);
		return "redirect:/facebook/pageEvent";
	}
	
	
}
