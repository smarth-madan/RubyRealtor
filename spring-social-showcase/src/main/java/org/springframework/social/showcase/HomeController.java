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

import javax.inject.Inject;
import javax.inject.Provider;
import javax.sql.DataSource;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.showcase.account.AccountRepository;
import org.springframework.social.showcase.customer.controller.CustomerHelper;
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
	

	@Inject
	public HomeController(Provider<ConnectionRepository> connectionRepositoryProvider, AccountRepository accountRepository,DataSource mysqldataSource) {
		this.mysqldataSource = mysqldataSource;
		mlsListingHelper = new MlsListingHelper(mysqldataSource);
		this.connectionRepositoryProvider = connectionRepositoryProvider;
		this.accountRepository = accountRepository;
		customerHelper = new CustomerHelper(mysqldataSource);
	}

	@RequestMapping("/")
	public String home(Principal currentUser, Model model) {
		model.addAttribute("connectionsToProviders", getConnectionRepository().findAllConnections());
		model.addAttribute(accountRepository.findAccountByUsername(currentUser.getName()));
		model.addAttribute("top5CustomersList", customerHelper.findTop5Customers());
		model.addAttribute("top5MlsListingsList", mlsListingHelper.getTop5PropertyDetails());
		
		return "home";
	}
	
	private ConnectionRepository getConnectionRepository() {
		return connectionRepositoryProvider.get();
	}
	
}
