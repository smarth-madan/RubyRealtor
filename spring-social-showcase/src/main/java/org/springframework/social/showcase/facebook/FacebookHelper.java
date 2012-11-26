package org.springframework.social.showcase.facebook;

import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.codehaus.jackson.JsonNode;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.Insights;
import org.springframework.social.facebook.api.Insights.Values;
import org.springframework.social.support.URIBuilder;

public class FacebookHelper {
	private final Facebook facebook;
	
	@Inject
	public FacebookHelper(Facebook facebook) {
		this.facebook = facebook;
		}

	public String getPageInsights(String uriString,String xAxisName, String yAxisName) {
		URI uri = URIBuilder.fromUri(uriString).build();
		JsonNode responseNode= facebook.restOperations().getForObject(uri, JsonNode.class);
		Insights insights = deserializeInsights(responseNode);
		StringBuffer graphJsonData = new StringBuffer();
		System.out.println(responseNode.toString());
		if(insights!=null){
			
			String title = insights.getTitle();
			title = title.replaceAll("\"", "");
			System.out.println("Title:"+title);
			graphJsonData.append("{ 'chart': { 'caption' : '"+title+"' , ");
			graphJsonData.append("'xAxisName' : '"+xAxisName+"', 'yAxisName' : '"+yAxisName+"', 'numberPrefix' : '$' }, 'data' : [ ");
			
		
			List<Values> valueList = insights.getValuesList();
			if(valueList!=null){
				System.out.println("Valuelist size: "+valueList.size());
				int listSize = valueList.size();
				for(Values value:valueList){
					listSize--;
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
						if(listSize!=0)
						graphJsonData.append("{ 'label' : '"+value.getEnd_time()+"', 'value' : '"+valueString+"' },");
						else if(listSize==0){
							graphJsonData.append("{ 'label' : '"+value.getEnd_time()+"', 'value' : '"+valueString+"' } ");
						}
					}
				}
				graphJsonData.append("] } ");
			}
		
		}
		
		System.out.println("Outside page id...");
		return graphJsonData.toString();
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
