package ch.studihome.jspserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.SignupForm;

@Controller
public class RegisterController {

    @Autowired
    SignupService signupService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
    	ModelAndView model = new ModelAndView("register");
    	model.addObject("signupForm", new SignupForm());    	
        return model;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	
    	ModelAndView model; 
    	
    	if (!signupForm.getPassword().equals(signupForm.getConfirmPassword())) {
        	model = new ModelAndView("register");
        	signupForm.setPassword("");
        	signupForm.setConfirmPassword("");
        	model.addObject("signupForm", signupForm);
        	
	    	BSalert[] alerts = new BSalert[1];
	    	alerts[0] = new BSalert(BSalert.Type.danger, "Passwords not matching");
	    	model.addObject("alerts", alerts);
    	} else if (!result.hasErrors()) {
            try {
            	signupService.saveFrom(signupForm);
            	model = new ModelAndView("index");
            	
    	    	BSalert[] alerts = new BSalert[1];
    	    	alerts[0] = new BSalert(BSalert.Type.success, "Sign Up Complete!");
    	    	model.addObject("alerts", alerts);
            } catch (InvalidUserException e) {
            	model = new ModelAndView("register");
            	signupForm.setPassword("");
            	signupForm.setConfirmPassword("");
            	model.addObject("signupForm", signupForm);
            	
    	    	BSalert[] alerts = new BSalert[1];
    	    	alerts[0] = new BSalert(BSalert.Type.danger, e.getMessage());
    	    	model.addObject("alerts", alerts);
            }
        } else {
        	model = new ModelAndView("register");
        }   	
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
    	BSalert[] alerts = new BSalert[1];
    	alerts[0] = new BSalert(BSalert.Type.danger, "You do have have permission to do that!");
        redirectAttributes.addFlashAttribute("alerts", alerts);
        return "redirect:/";
    }

}


