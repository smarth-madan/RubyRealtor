/*
 * Copyright 2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.showcase;

import java.security.Principal;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.showcase.account.Account;
import org.springframework.social.showcase.account.AccountRepository;
import org.springframework.social.showcase.customer.helper.CustomerHelper;
import org.springframework.social.showcase.mlsListing.helper.MlsListingHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	private final Provider<ConnectionRepository> connectionRepositoryProvider;
	private final AccountRepository accountRepository;
	private DataSource mysqldataSource;
	private static MlsListingHelper mlsListingHelper;
	private static CustomerHelper customerHelper;
	
	@Autowired
	private SessionRealtor sessionRealtor;

	@Inject
	public HomeController(Provider<ConnectionRepository> connectionRepositoryProvider, AccountRepository accountRepository,DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		mlsListingHelper = new MlsListingHelper(mysqldataSource);
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.accountRepository = accountRepository;
		customerHelper = new CustomerHelper(mysqldataSource);
	}

	@RequestMapping("/")
	public String home(HttpServletRequest request, Principal currentUser, Model model) {
		Account account = accountRepository.findAccountByUsername(currentUser.getName());
		
		model.addAttribute(account);
		sessionRealtor.setRealtorId(account.getR_ID());
		Map<String, List<Connection<?>>> connections = getConnectionRepository().findAllConnections();
		model.addAttribute("connectionsToProviders", connections);
		try{
			model.addAttribute("image", getConnectionRepository().findAllConnections().getFirst("facebook"));
		}catch(Exception e){
			
		}
		model.addAttribute("top5CustomersList", customerHelper.findTop5Customers(account.getR_ID()));
		model.addAttribute("top5MlsListingsList", mlsListingHelper.getTop5PropertyDetails());

		StringBuffer graphJsonData = new StringBuffer();
	    graphJsonData.append("{ \"chart\": { \"caption\" : \"Weekly Sales Summary\" , ");
		graphJsonData.append("\"xAxisName\" : \"Week\", \"yAxisName\" : \"Sales\", \"numberPrefix\" : \"$\" }, ");
		graphJsonData.append("\"data\" : [ { \"label\" : \"Week 1\", \"value\" : \"14400\" },  ");
		graphJsonData.append("{ \"label\" : \"Week 2\", \"value\" : \"19600\" },  ");
		graphJsonData.append("{ \"label\" : \"Week 3\", \"value\" : \"24000\" }, ");
		graphJsonData.append("{ \"label\" : \"Week 4\", \"value\" : \"15700\" } ] } ");
		//String temp = "{ \"chart\": { \"caption\" : \"Weekly Sales Summary\" , \"xAxisName\" : \"Week\", \"yAxisName\" : \"Sales\", \"numberPrefix\" : \"$\" },\"data\" : [ { \"label\" : \"Week 1\", \"value\" : \"14400\" },{ \"label\" : \"Week 2\", \"value\" : \"19600\" },{ \"label\" : \"Week 3\", \"value\" : \"24000\" },{ \"label\" : \"Week 4\", \"value\" : \"15700\" } ]    } ";
		String temp = "{ 'chart': { 'caption' : 'Weekly Sales Summary' , 'xAxisName' : 'Week', 'yAxisName' : 'Sales', 'numberPrefix' : '$' },'data' : [ { 'label' : 'Week 1', 'value' : '14400' },{ 'label' : 'Week 2', 'value' : '19600' },{ 'label' : 'Week 3', 'value' : '24000' },{ 'label' : 'Week 4', 'value' : '15700' } ]    }";
		System.out.println(graphJsonData.toString());
		System.out.println(temp);
		model.addAttribute("graphJsonData", temp);

		
		//return "home";
		if(connections.get("facebook").isEmpty())
			return "forward:/connect/facebook";
		else
			return "home";
		
	}
	
	
	@RequestMapping("/home")
	public String homeInside(HttpServletRequest request, Principal currentUser, Model model) {
		Account account = accountRepository.findAccountByUsername(currentUser.getName());
		
		model.addAttribute(account);
		sessionRealtor.setRealtorId(account.getR_ID());
		Map<String, List<Connection<?>>> connections = getConnectionRepository().findAllConnections();
		model.addAttribute("connectionsToProviders", connections);
		try{
			model.addAttribute("image", getConnectionRepository().findAllConnections().getFirst("facebook"));
		}catch(Exception e){
			
		}
		model.addAttribute("top5CustomersList", customerHelper.findTop5Customers(account.getR_ID()));
		model.addAttribute("top5MlsListingsList", mlsListingHelper.getTop5PropertyDetails());
		
		return "home";
		
	}
	
	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}
	
}
