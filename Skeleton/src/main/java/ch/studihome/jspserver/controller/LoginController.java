package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.BSalert;

/**
 * Controller for redirect tasks
 * 
 * @author TeamSix
 */

@Controller
public class LoginController {

    @Autowired
    SignupService sampleService;

	/**
	 * Show error message after failes login attempt
	 * 
	 * @param error Error message
	 * @return Login view
	 */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error) {
	 
		  ModelAndView model = new ModelAndView("login");
		  if (error != null) {
		    	BSalert[] alerts = new BSalert[1];
		    	alerts[0] = new BSalert(BSalert.Type.danger, "Invalid user name and password!");
		    	model.addObject("alerts", alerts);
		  }
	 
		  return model;
    }
    
    @RequestMapping(value = "/haslogin", method = RequestMethod.GET)
	public String haslogin() {
	 
    	User fromUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
    	//TODO
	 
    	return "redirect:/index";
    }
    
    /**
     * Redirect user after logout
     * @param redirectAttributes To inform user
     * @return index view 
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(RedirectAttributes redirectAttributes)
    {
    	BSalert[] alerts = new BSalert[1];
    	alerts[0] = new BSalert(BSalert.Type.success, "You've been logged out successfully.");
        redirectAttributes.addFlashAttribute("alerts", alerts);
        return "redirect:/";
    }
}