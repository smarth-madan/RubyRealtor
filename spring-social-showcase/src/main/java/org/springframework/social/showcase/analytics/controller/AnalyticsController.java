package org.springframework.social.showcase.analytics.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.showcase.facebook.FacebookHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnalyticsController {
	
	private static FacebookHelper facebookHelper;
	private final Facebook facebook;
	
	@Inject
	public AnalyticsController(DataSource mysqldataSource,Facebook facebook) {
		this.facebook = facebook;
		facebookHelper = new FacebookHelper(facebook);
			}
	
	@RequestMapping("/analytics")
	public ModelAndView home(Model model) {
		
		String createdJsonSTring = facebookHelper.getPageInsights("https://graph.facebook.com/277500075678192/insights/page_admin_num_posts/week?since=1350951649&until=1351210849","Time","Number of Posts");
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("graphJsonData", createdJsonSTring);
		mv.setViewName("analytics/analytics");
		return mv;
				
	}


}
