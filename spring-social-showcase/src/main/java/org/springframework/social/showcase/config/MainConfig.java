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
package org.springframework.social.showcase.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseFactory;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.account.JdbcAccountRepository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import com.mysql.jdbc.Driver;

/**
 * Main configuration class for the application.
 * Turns on @Component scanning, loads externalized application.properties, and sets up the database.
 * @author Craig Walls
 */
@Configuration
@ComponentScan(basePackages = "org.springframework.social.showcase", excludeFilters = { @Filter(Configuration.class) })
@PropertySource("classpath:org/springframework/social/showcase/config/application.properties")
@EnableTransactionManagement
public class MainConfig {

//	@Bean(destroyMethod = "shutdown")
//	public DataSource dataSource() {
//		EmbeddedDatabaseFactory factory = new EmbeddedDatabaseFactory();
//		factory.setDatabaseName("spring-social-showcase");
//		factory.setDatabaseType(EmbeddedDatabaseType.H2);
//		factory.setDatabasePopulator(databasePopulator());
//		return factory.getDatabase();
//	}
	
	@Bean
	public DriverManagerDataSource mysqldataSource() {
		@SuppressWarnings("deprecation")
		DriverManagerDataSource factory = new DriverManagerDataSource("com.mysql.jdbc.Driver",
																		"jdbc:mysql://localhost/realtor_social",
																		"realtor",
																	    "realtor");
		/*DriverManagerDataSource factory = new DriverManagerDataSource("com.mysql.jdbc.Driver",
				"jdbc:mysql://ec2-184-169-207-210.us-west-1.compute.amazonaws.com/realtor_social",
				"realtor",
			"realtor");*/
		return factory;
	}
	
	
	@Bean
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public SessionRealtor sessionRealtor() {
		return new SessionRealtor("1");
	}
	
	
	@Bean
	public PlatformTransactionManager transactionManager() {
		return new DataSourceTransactionManager(mysqldataSource());
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(mysqldataSource());
	}

	// internal helpers

	private DatabasePopulator databasePopulator() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
		populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql", JdbcUsersConnectionRepository.class));
		//populator.addScript(new ClassPathResource("Account.sql", JdbcAccountRepository.class));
		//populator.addScript(new ClassPathResource("data.sql", JdbcAccountRepository.class));
		return populator;
	}
}
