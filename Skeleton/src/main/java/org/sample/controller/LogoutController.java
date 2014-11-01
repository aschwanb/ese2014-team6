package org.sample.controller;

import org.sample.controller.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

    @Autowired
    SignupService sampleService;


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout () { 
		ModelAndView model = new ModelAndView("logout");  
    	return model;
    }
}