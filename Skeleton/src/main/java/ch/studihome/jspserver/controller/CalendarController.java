package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.User;

/**
 * Load and return calendar view
 * 
 * @author TeamSix
 */
@Controller
public class CalendarController {
	
	@Autowired MyUserDetailsService userService;

	/**
	 * 
	 * @return calendar view
	 */
	@RequestMapping(value = "/calendar", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("calendar");
    	
        User user = userService.getUser();
    	model.addObject("user", user);
    	
    	return model;
    }

}


