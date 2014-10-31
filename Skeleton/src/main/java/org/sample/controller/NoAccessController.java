package org.sample.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.model.pojos.SignupForm;
import org.sample.controller.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class NoAccessController {

    @RequestMapping(value = "/noAccess", method = RequestMethod.GET)
    public ModelAndView noAccess(Principal user) {
    	ModelAndView model = new ModelAndView("noAccess");
    	if (user != null) {
    		model.addObject("msg", "Sorry " + user.getName() + 
    				", you do not have permission to access this page!");
     	} else {
     		model.addObject("msg", "You don't have the permission to access this page.");
     	}
    	return model;
    }

}


