package org.springframework.social.showcase.email;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmailController {
	
	private static GoogleMail googleMail;
	
	@Inject
	public EmailController(DataSource mysqldataSource) {
		
	}
	
	@RequestMapping("/emailCustomer")
	public ModelAndView emailCustomer() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer/emailCustomer");
		return mv;
	}

	@RequestMapping("/sendEmail")
	public ModelAndView sendEmail(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("customer/emailCustomer");
		return mv;
	}
}
