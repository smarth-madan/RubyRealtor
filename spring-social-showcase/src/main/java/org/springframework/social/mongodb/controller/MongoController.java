package org.springframework.social.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.social.mongodb.data.PersonRepository;
import org.springframework.social.mongodb.model.Person;

public class MongoController {

	@Autowired
	static
	MongoOperations mongoOperations;

	static ConfigurableApplicationContext context;
	
	public static void main( String[] args ) {
		System.out.println("Bootstrapping HelloMongo");
		// use @Configuration using Java:
        context = new ClassPathXmlApplicationContext("/resources/ApplicationContext.xml");
        
        run();
        
        System.out.println( "DONE!" );
	}
	
	public static void run() {
		PersonRepository personRepository = context.getBean(PersonRepository.class);
		 
	    // cleanup person collection before insertion
	    personRepository.dropPersonCollection();
	 
	    //create person collection
	    personRepository.createPersonCollection();
	 
	    for(int i=0; i<20; i++) {
	      personRepository.insertPersonWithNameJohnAndRandomAge();
	    }
	}
}
