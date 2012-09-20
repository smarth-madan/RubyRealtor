//package org.springframework.social.showcase.realtor.controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.social.mongodb.controller.MongoController;
//import org.springframework.social.showcase.realtor.model.Customer;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//public class CustomerController {
//
//	@RequestMapping("/customers")
//	public String home(Model model) {
//		Customer customer = new Customer();
//		customer.setFname("John");
//		customer.setLname("Doe");
//		customer.setEmailId("john.doe@mail.com");
//		customer.setAddress("148, E. William St.,Apt#21,San Jose, CA 95112");
//		customer.setRealtorId("R0012345");
//		customer.setCustomerId("C100000");
//		
//		Customer customer1 = new Customer();
//		customer1.setFname("John");
//		customer1.setLname("Doe");
//		customer1.setEmailId("john.doe@mail.com");
//		customer1.setAddress("148, E. William St.,Apt#21,San Jose, CA 95112");
//		customer1.setRealtorId("R0012345");
//		customer1.setCustomerId("C100000");
//		
//		List<Customer> customerList = new ArrayList<Customer>();
//		customerList.add(customer);
//		customerList.add(customer1);
//		model.addAttribute("customerList", customerList);
//		//return "home";
//		
//		MongoController.home();
//		return "realtor/CustomerList";
//	}
//}
