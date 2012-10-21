package org.springframework.social.showcase.facebook;

import java.util.Properties;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.showcase.SessionRealtor;
import org.springframework.social.showcase.customer.controller.CustomerHelper;
import org.springframework.social.showcase.customer.model.FBCustomer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FacebookContactUsController {
	
private static CustomerHelper customerHelper;
	
	@Autowired
	private SessionRealtor sessionRealtor;
	//private final Facebook facebook;
	
	Properties properties = new Properties();
	//private String pageId;

	@Inject
	public FacebookContactUsController( DataSource mysqldataSource) {
		//this.facebook = facebook;
		customerHelper = new CustomerHelper(mysqldataSource);
	}
	
	@RequestMapping(value="/contactUs", method=RequestMethod.POST)
	public ModelAndView contactUsPage(String message) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("facebook/contactUs");
		return mv;
	}

	@RequestMapping(value="/registerFromFB", method=RequestMethod.POST)
	public ModelAndView registerFromFB(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("input") FBCustomer inputModel) {
		ModelAndView mv = new ModelAndView();
		System.out.println("city="+inputModel.getCity());
		System.out.println("state="+inputModel.getState());
		System.out.println("street="+inputModel.getStreet());
		System.out.println("zipcode="+inputModel.getZipcode());
		System.out.println("fname="+inputModel.getfName());
		System.out.println("lname="+inputModel.getlName());
		System.out.println("email ID="+inputModel.getEmail_ID());
		System.out.println("p no="+inputModel.getPhone_number());
		System.out.println("mar status"+inputModel.getMartial_status());
		System.out.println("min="+inputModel.getSalary_min_val());
		System.out.println("max="+inputModel.getSalary_max_val());
		System.out.println("aptmnt="+inputModel.getAppointment());
		System.out.println("type="+inputModel.getType_house());
		System.out.println("type="+inputModel.getType_apartment());
		System.out.println("type="+inputModel.getType_studio());
		System.out.println("range="+inputModel.getRange_gt_400k());
		System.out.println("range="+inputModel.getRange_100k_400k());
		System.out.println("range="+inputModel.getRange_lt_100k());
		inputModel.setR_ID(String.valueOf((sessionRealtor.getRealtorId())));
		inputModel.setR_ID("1");
		inputModel.setCustomer_priority("1");
		int newCustomerId = customerHelper.addFBCustomer(inputModel);
		if(newCustomerId >=0 ){
			System.out.println("newCustomerId=="+newCustomerId);
			customerHelper.addFBCustomerReq(inputModel, newCustomerId);
			mv.addObject("result", "Thank you. Your profile has been created, the Real estate Agent will be in touch with you soon");
			mv.setViewName("realtor/result");
		}
		else{
			mv.setViewName("realtor/result");
			mv.addObject("result", "Sorry, Customer could not be added due to internal error!!!");
		}
		mv.setViewName("realtor/result");
		return mv;
	}

}
