package org.sample.controller;

import org.sample.controller.service.SignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    SignupService sampleService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
	 
		  ModelAndView model = new ModelAndView();
		  if (error != null) {
			model.addObject("error", "Invalid email and password!");
		  }
	 
		  if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		  }
		  model.setViewName("login");
	 
		  return model;
    }
    
    //    public ModelAndView index() {
//    	ModelAndView model = new ModelAndView("login");
//    	return model;
//    }
}