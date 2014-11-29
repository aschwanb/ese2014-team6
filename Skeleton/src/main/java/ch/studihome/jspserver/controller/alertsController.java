package ch.studihome.jspserver.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.User;

/**
 * Load and return user profile view 
 * 
 * @author TeamSix
 */
@Controller
public class alertsController {

	/**
	 * 
	 * @return alerts view
	 */
	@RequestMapping(value = "/alerts", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("alerts");
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	model.addObject("user", user);
    	
    	//TODO

    	return model;
    }

}


