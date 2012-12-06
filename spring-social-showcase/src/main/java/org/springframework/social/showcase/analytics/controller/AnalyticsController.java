package org.springframework.social.showcase.analytics.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.showcase.account.AccountRepository;
import org.springframework.social.showcase.facebook.FacebookHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AnalyticsController {
	
	private final Provider<ConnectionRepository> connectionRepositoryProvider;
	private final AccountRepository accountRepository;
	private static FacebookHelper facebookHelper;
	private final Facebook facebook;
	
	@Inject
	public AnalyticsController(DataSource mysqldataSource,Facebook facebook,Provider<ConnectionRepository> connectionRepositoryProvider, AccountRepository accountRepository) {
		this.facebook = facebook;
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.accountRepository = accountRepository;
		facebookHelper = new FacebookHelper(facebook);
			}
	
	@RequestMapping("/analytics")
	public ModelAndView home(Model model) {
		ModelAndView mv = new ModelAndView();
		Map<String, List<Connection<?>>> connections = getConnectionRepository().findAllConnections();
		long currentTime = System.currentTimeMillis()/1000;
		long oldTime = currentTime - (86400*10);
		long oldTime2 = currentTime - (86400*30);
		
		if(!connections.get("facebook").isEmpty()){
			String createdJsonString1 = facebookHelper.getPageInsights("https://graph.facebook.com/277500075678192/insights/page_admin_num_posts/week?since="+oldTime+"&until="+currentTime,"Time","Number of Posts");

			String createdJsonString2 = facebookHelper.getPageInsights("https://graph.facebook.com/277500075678192/insights/page_views_login/day?since="+oldTime+"&until="+currentTime,"Time","Page Views");
		
			String createdJsonString3 = facebookHelper.getPageInsights("https://graph.facebook.com/277500075678192/insights/page_story_adds/week?since="+oldTime+"&until="+currentTime,"Time","Page Stories");
			
			String  createdJsonString4 = facebookHelper.getPageInsights("https://graph.facebook.com/277500075678192/insights/page_impressions_unique/days_28?since="+oldTime2+"&until="+currentTime,"Time","Page Reach");
			
			mv.addObject("graphJsonData1", createdJsonString1);
			mv.addObject("graphJsonData2", createdJsonString2);
			mv.addObject("graphJsonData3", createdJsonString3);
			mv.addObject("graphJsonData4", createdJsonString4);
		}
		
		
		mv.setViewName("analytics/analytics");
		return mv;
				
	}	
	
	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}


}
