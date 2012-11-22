package org.springframework.social.showcase.customer.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.customer.helper.CustomerHelper;
import org.springframework.social.showcase.customer.model.CRequirements;
import org.springframework.social.showcase.customer.model.Customer;
import org.springframework.social.showcase.customer.model.FBCustomer;
import org.springframework.social.showcase.email.GoogleMail;
import org.springframework.social.showcase.mlsListing.model.Property;
import org.springframework.social.showcase.solr.SolrHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@SessionAttributes({"customerId","customers","propertyList"})
@Controller
@RequestMapping("/customer")
public class CustomerController {

	private static CustomerHelper customerHelper;
	private static SolrHelper solrHelper;

	@Autowired
	private SessionRealtor sessionRealtor;

	@Inject
	public CustomerController(DataSource mysqldataSource) {
		customerHelper = new CustomerHelper(mysqldataSource);
		solrHelper = new SolrHelper(mysqldataSource);
	}

	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView viewCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<Customer> customers = customerHelper.findAllCustomers(sessionRealtor.getRealtorId());
		mv.addObject("customers",customers);
		mv.setViewName("customer/viewCustomer");
		return mv;

	}

	@RequestMapping(value="/add",  method=RequestMethod.GET)
	public ModelAndView addCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer/addCustomer");
		return mv;
	}

	@RequestMapping(value="/getAppt",  method=RequestMethod.GET)
	public ModelAndView getApptCustomer(HttpServletRequest request, HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		List<Customer> customers = customerHelper.findCustomerAppt(sessionRealtor.getRealtorId());
		mv.addObject("customers",customers);
		mv.setViewName("customer/appointments");
		return mv;
	}
	
	@RequestMapping(value="/registerFromFB", method=RequestMethod.POST)
	public ModelAndView registerFromFB(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") FBCustomer inputModel) {
		ModelAndView mv = new ModelAndView();

		System.out.println("numberofPersons="+inputModel.getNumber_of_persons());

		inputModel.setR_ID(String.valueOf((sessionRealtor.getRealtorId())));
		inputModel.setR_ID("1");
		inputModel.setCustomer_priority("1");
		int newCustomerId = customerHelper.addFBCustomer(inputModel);
		if(newCustomerId >=0 ){
			System.out.println("newCustomerId=="+newCustomerId);
			int result = customerHelper.addFBCustomerReq(inputModel, newCustomerId);
			if(result!=-1){
				mv.addObject("result", "Thank you. Your profile has been created, the Real estate Agent will be in touch with you soon");
			}
			else{
				mv.addObject("result", "Sorry, We could not create your profile due to internal error!!!");
			}
		}
		else{
			mv.addObject("result", "Sorry, We could not create your profile due to internal error!!!");
		}
		mv.setViewName("customer/addCustomer");
		return mv;
	}


	@RequestMapping(value="/add", method=RequestMethod.POST)
	public ModelAndView addCustomerSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") FBCustomer inputModel){
		ModelAndView mv = new ModelAndView();

		System.out.println("numberofPersons="+inputModel.getNumber_of_persons());

		inputModel.setR_ID(String.valueOf((sessionRealtor.getRealtorId())));
		inputModel.setR_ID("1");
		inputModel.setCustomer_priority("1");
		int newCustomerId = customerHelper.addFBCustomer(inputModel);
		if(newCustomerId >=0 ){
			System.out.println("newCustomerId=="+newCustomerId);
			int result = customerHelper.addFBCustomerReq(inputModel, newCustomerId);
			if(result!=-1){
				mv.addObject("result", "Customer added successfully!!!");
			}
			else{
				mv.addObject("result", "Sorry, Customer could not be added due to internal error!!!");
			}
		}
		else{
			mv.addObject("result", "Sorry, Customer could not be added due to internal error!!!");
		}
		mv.setViewName("customer/addCustomer");
		return mv;
	}

	@RequestMapping(value="/addReq", method=RequestMethod.POST)
	public ModelAndView addCustomerReqSubmit(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") CRequirements inputModel,@ModelAttribute("customerId") int customerId){
		ModelAndView mv = new ModelAndView();
		int newCustomerReqId = customerHelper.addCustomerReq(inputModel);

		if(newCustomerReqId >=0 ){
			mv.setViewName("customer/addCustomerRequirements");
			Boolean success = customerHelper.updateCustomer(customerId,newCustomerReqId);
			if(success){
				mv.setViewName("realtor/result");
			}
			else{
				mv.setViewName("error/error");
				mv.addObject("error", "Sorry, Customer Requirement could not be added due to internal error!!!");
			}
		}
		else{
			mv.setViewName("error/error");
			mv.addObject("error", "Sorry, Customer Requirement could not be added due to internal error!!!");
			//TODO: Remove the customer also.
		}

		return mv;
	}

	@RequestMapping(value="/edit" , method=RequestMethod.POST)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("c_id") String c_id, @ModelAttribute("customers") List<Customer> customers){
		ModelAndView mv = new ModelAndView();
		for (Customer customer : customers){
			if(c_id.equalsIgnoreCase(customer.getC_id())){
				mv.addObject("customer", customer);
				mv.setViewName("customer/editCustomer");
			}
		}
		return mv;
	}

	@RequestMapping(value="/editSubmit" , method=RequestMethod.POST)
	public ModelAndView editCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("input") Customer customer){
		ModelAndView mv = new ModelAndView();
		Boolean success = customerHelper.editCustomer(customer);
		if(success){
			mv.setViewName("realtor/result");
			mv.addObject("result", "Customer data updated Successfully.");
		}
		return mv;	
	}

	@RequestMapping(value="/match",  method=RequestMethod.POST)
	public ModelAndView matchCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("input")Customer customer){

		CRequirements cRequirements = customerHelper.getCustomerReq(customer).get(0);

		List<Property> propertyList = solrHelper.searchListing(cRequirements);

		ModelAndView mv = new ModelAndView();
		mv.addObject("propertyList", propertyList);
		mv.addObject("customerId", customer.getC_id());
		mv.setViewName("customer/matchResult");
		//mv.setViewName("realtor/PropertyList");
		return mv;
	}


	@RequestMapping(value="/emailPropertyList",  method=RequestMethod.POST)
	public ModelAndView emailCustomer(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("propertyList")List<Property> propertyList, @ModelAttribute("customerId")String c_id){

		Customer eCustomer = customerHelper.getCustomer(c_id);

		//List<Property> propertyList = solrHelper.searchListing(cRequirements);
		Property property = new Property();
		property.setMLS_ID("1");
		property.setCity("San Jose");
		property.setStreet("148, E. William Street");
		property.setState("CA");
		property.setZipcode("95112");
		propertyList.add(property);
		ModelAndView mv = new ModelAndView();
		//mv.addObject("htmlContent", buildHtmlEmailContent(propertyList).toString());
		mv.addObject("propertyList",propertyList);
		mv.addObject("subject","Awesome Realtors: Suggested properties for you");
		mv.addObject("customerEmailId", eCustomer.getEmail_ID());
		//mv.setViewName("customer/matchResult");
		mv.setViewName("customer/emailCustomer");
		return mv;
	}

	@RequestMapping("/emailCustomer")
	public ModelAndView emailCustomer(String c_id) {
		ModelAndView mv = new ModelAndView();
		Customer eCustomer = customerHelper.getCustomer(c_id);
		mv.addObject("subject","Awesome Realtors: <subject>");
		mv.addObject("customerEmailId", eCustomer.getEmail_ID());
		mv.addObject("propertyList",new ArrayList<Property>());
		mv.setViewName("customer/emailCustomer");
		return mv;
	}


	@RequestMapping(value="/sendEmail" , method=RequestMethod.POST)
	public ModelAndView sendEmail(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("propertyList")List<Property> propertyList) {
		String to = request.getParameter("to");
		String cc = request.getParameter("cc");
		String subject = request.getParameter("subject");
		String message = request.getParameter("message");
		String defaultMessage = "Properties selected for you:";
		ModelAndView mv = new ModelAndView();
		if(propertyList!=null && propertyList.size()>0){
			//System.out.println("Got ittttt..."+propertyList.size());
			try {
				if(message==null || "".equals(message)){
					GoogleMail.Send("awesomerealtor007", "AwesomeRealtor17", "awesomerealtor007@gmail.com", cc, subject, defaultMessage+"<br /><br />"+buildHtmlEmailContent(propertyList).toString());
				}else{
					GoogleMail.Send("awesomerealtor007", "AwesomeRealtor17", "awesomerealtor007@gmail.com", cc, subject, message+"<br /><br />"+buildHtmlEmailContent(propertyList).toString());
				}
				mv.addObject("result", "An email listing the matched properties have been sent to "+to+" .");
			} catch (AddressException e) {
				mv.addObject("result", "Incorrect Email Ids. You tried sending email to "+to+" from your email Id awesomerealtor007@gmail.com. Please check on all email Ids");
			} catch (MessagingException e) {
				mv.addObject("result", "Problem with the message being sent .");
			}
		}else if(StringUtils.hasText(message)){
			try {
				GoogleMail.Send("awesomerealtor007", "AwesomeRealtor17",to, cc, subject, message);
				mv.addObject("result", "An email has been sent to "+to+" .");
			} catch (AddressException e) {
				mv.addObject("result", "Incorrect Email Ids. You tried sending email to "+to+" from your email Id awesomerealtor007@gmail.com. Please check on all email Ids");
				e.printStackTrace();
			} catch (MessagingException e) {
				mv.addObject("result", "Problem with the message being sent .");
				e.printStackTrace();
			}
		}

		mv.setViewName("realtor/result");
		return mv;
	}

	public StringBuffer buildHtmlEmailContent(List<Property> propertyList){
		StringBuffer htmlContent = new StringBuffer();

		for(Property property: propertyList){
			htmlContent.append("<table border='0'><tr><td>");

			htmlContent.append("<table border='0'>");
			htmlContent.append("<tr  style='background-color: #0099CC;'><td><b>Property :</b></td><td></td></tr>");
			htmlContent.append("<tr style='background-color: #D0D0D0 ;'>");
			htmlContent.append("<td>MLS ID</td><td>");
			htmlContent.append(property.getMLS_ID());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#E0E0E0;'>");
			htmlContent.append("<td>Size</td><td>");
			htmlContent.append(property.getSize());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #D0D0D0 ;'>");
			htmlContent.append("<td>Address</td><td>");
			htmlContent.append(property.getStreet()+" ,"+property.getCity()+" '"+property.getState()+" ,"+property.getZipcode());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#E0E0E0;'>");
			htmlContent.append("<td>Price</td><td>");
			htmlContent.append(property.getPrice());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #D0D0D0 ;'>");
			htmlContent.append("<td>Type</td><td>");
			htmlContent.append(property.getType());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color:#E0E0E0;'>");
			htmlContent.append("<td>Bed/Bath</td><td>");
			htmlContent.append(property.getBed_bath());
			htmlContent.append("</td></tr>");

			htmlContent.append("<tr style='background-color: #D0D0D0 ;'>");
			htmlContent.append("<td>Garage</td><td>");
			htmlContent.append(property.getGarage());
			htmlContent.append("</td></tr>");



			htmlContent.append("<tr style='background-color:#E0E0E0;'>");
			htmlContent.append("<td>Parking</td><td>");
			htmlContent.append(property.getParking());
			htmlContent.append("</td></tr></table>");

			htmlContent.append("</td><td valign='top'><table><tr style='background-color: #0099CC;'><td><i><font style='valign:top'><b>Image: </b></font></i><br /></td></tr>");
			htmlContent.append("<tr><td><img height='125' width='180' src='http://localhost:8080/spring-social-showcase/resources/images//property1.gif' alt='No Image Available' /></td></tr></table></td></tr></table>");
		}
		return htmlContent;

	}

}
