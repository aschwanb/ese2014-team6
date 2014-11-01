package ch.studihome.jspserver.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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


