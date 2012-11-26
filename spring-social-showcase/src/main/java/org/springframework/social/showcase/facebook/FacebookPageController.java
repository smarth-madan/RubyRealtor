package org.springframework.social.showcase.facebook;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.FacebookLink;
import org.springframework.social.facebook.api.Insights;
import org.springframework.social.facebook.api.Insights.Values;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.Post;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.customer.helper.CustomerHelper;
import org.springframework.social.support.URIBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FacebookPageController {

private static CustomerHelper customerHelper;
	
	@Autowired
	private SessionRealtor sessionRealtor;
	private final Facebook facebook;
	
	Properties properties = new Properties();
	private String pageId;

	@Inject
	public FacebookPageController(Facebook facebook, DataSource mysqldataSource) {
		this.facebook = facebook;
		customerHelper = new CustomerHelper(mysqldataSource);
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
		model.addAttribute("page",page);
		List<Post> posts = facebook.feedOperations().getFeed(pageId);
		model.addAttribute("feed", posts);
		return "facebook/page";
	}
	
	@RequestMapping(value="/facebook/page", method=RequestMethod.POST)
	public String postUpdate(String message) {
		facebook.feedOperations().post(this.pageId,message);
		return "redirect:/facebook/page";
	}
	
	
	@RequestMapping(value="/facebook/page/postLink", method=RequestMethod.POST)
	public String postUpdateLink(String link, String message) {
		facebook.feedOperations().postLink(this.pageId,message,new FacebookLink(link,"","",""));
		return "redirect:/facebook/page";
	}

	@RequestMapping(value="/facebook/pageEvent", method=RequestMethod.GET)
	public String createEvent() {
		return "facebook/pageEvent";
	}
	
	@RequestMapping(value="/facebook/pageEvent", method=RequestMethod.POST)
	public String postEvent(String name, String startTime, String endTime, String description, String location) {
		MultiValueMap<String, Object> data = new LinkedMultiValueMap<String, Object>();
		data.set("name", name);
		data.set("start_time", startTime);
		data.set("end_time", endTime);
		data.set("description",description);
		data.set("location", location);
		//data.set("end_time", endTime);
		facebook.publish(this.pageId, "events", data);
		return "redirect:/facebook/pageEvent";
	}
	
	@RequestMapping(value="/facebook/pageInsights", method=RequestMethod.GET)
	public String getPageInsights() {
		URI uri = URIBuilder.fromUri( "https://graph.facebook.com/277500075678192/insights/page_story_adds_by_story_type_unique/day").build();
		URI uri2 = URIBuilder.fromUri( "https://graph.facebook.com/277500075678192/insights/page_admin_num_posts/week?since=1350951649&until=1351210849").build();
		// facebook.insightsOperations().pageViews(this.pageId);
		
		JsonNode responseNode= facebook.restOperations().getForObject(uri2, JsonNode.class);
		Insights insights = deserializeInsights(responseNode);
		System.out.println(responseNode.toString());
		if(insights!=null){
			System.out.println("Title:"+insights.getTitle());
			System.out.println("Description:"+insights.getDescription());
			System.out.println("Name:"+insights.getName());
			System.out.println("Period:"+insights.getPeriod());
			List<Values> valueList = insights.getValuesList();
			if(valueList!=null){
				for(Values value:valueList){
					if(value!=null){
						Integer valueString = -1;
						HashMap<String, Integer> valueMap = value.getValue();
						Iterator it = valueMap.entrySet().iterator();
					    while (it.hasNext()) {
					        Map.Entry pairs = (Map.Entry)it.next();
					        valueString = (Integer)pairs.getValue();
					        //it.remove(); // avoids a ConcurrentModificationException
					    }
						System.out.println("valueString ="+valueString);
						System.out.println("Time ="+value.getEnd_time());
					}
				}
			}
		}
		/*if(this.pageId!=null && facebook!=null && facebook.insightsOperations()!=null){
			System.out.println("Inside page id...");
			Insights i = facebook.insightsOperations().pageViews(this.pageId);
			Insights i1 = facebook.insightsOperations().pageFanAdds(this.pageId);
			Insights i2= facebook.insightsOperations().pageFansAge(this.pageId);
			sList<Values> valueLit = i.getValuesList();
			System.out.println("INSIGHT DATA:"+i.toString());
		}*/
		System.out.println("Outside page id...");
		return "facebook/pageEvent";
	}

	private Insights deserializeInsights(JsonNode jsonNode) 
	{
		Insights data = new Insights();
		JsonNode dataNode = jsonNode.get("data");
		JsonNode valuesNode = dataNode.findValue("values");
		
		data.setId(dataNode.findValue("id").toString());
		data.setName(dataNode.findValue("name").toString());
		data.setPeriod(dataNode.findValue("period").toString());
		data.setTitle(dataNode.findValue("title").toString());
		data.setDescription(dataNode.findValue("description").toString());
		
		// Now we get into "Values node" to get list of "value"s
		for (Iterator<JsonNode> valuesElements = valuesNode.getElements(); valuesElements.hasNext();) 
		{
			JsonNode valuesElement = valuesElements.next();
			Values tmp_val = new Values();
			boolean isValueList = false;
			
			// Now we get into one of "Value" nodes from Values list
			// to get a list of data that is interesting for us + end_time
			for (Iterator<JsonNode> valueElement = valuesElement.getElements(); valueElement.hasNext();)
			{
				JsonNode valueNode = valueElement.next();
				
				Iterator<Entry<String, JsonNode>> dataList = valueNode.getFields();
				if (dataList.hasNext())
				{
					for (; dataList.hasNext() ;)
					{
						Entry<String, JsonNode> dataListElement = dataList.next();
						tmp_val.putValue(dataListElement.getKey(), dataListElement.getValue().asInt());
					}
				
					tmp_val.setEnd_time(valuesElement.findValue("end_time").asText());
					isValueList = true;
				}
				
				if (!isValueList)
				{
					tmp_val.setEnd_time(valuesElement.findValue("end_time").asText());
					tmp_val.putValue("value", valuesElement.findValue("value").asInt());
				}
			}
			data.addValues(tmp_val);
		}
		
		return data;
	}
	
	
}
