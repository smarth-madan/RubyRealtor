package org.springframework.social.showcase.analytics.controller;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnalyticsController {
	
	
	@Inject
	public AnalyticsController(DataSource mysqldataSource) {
			}
	
	@RequestMapping("/analytics")
	public ModelAndView home(Model model) {
		
		
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("analytics/analytics");
		return mv;
				
	}


}
