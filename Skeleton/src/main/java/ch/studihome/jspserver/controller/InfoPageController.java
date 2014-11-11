package ch.studihome.jspserver.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.pojos.BSalert;

/**
 * Load and return info/ access denied view 
 * 
 * @author TeamSix
 */
@Controller
public class InfoPageController {

	/**
	 * 
	 * @param user User object
	 * @return access denied page
	 */
    @RequestMapping(value = "/noAccess", method = RequestMethod.GET)
    public ModelAndView noAccess(Principal user) {
    	ModelAndView model = new ModelAndView("infoPage");
    	model.addObject("title", "Access denied!");
    	BSalert[] alerts = new BSalert[1];
    	if (user != null) {
    		alerts[0] = new BSalert(BSalert.Type.danger, "Sorry " + user.getName() + ", you do not have permission to access this page!");
     	} else {
    		alerts[0] = new BSalert(BSalert.Type.danger, "You don't have the permission to access this page.");
     	}
    	model.addObject("alerts", alerts);
    	return model;
    }

    /* Add other specialized Request handling for infoPage here */
}


