package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.SignupService;

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