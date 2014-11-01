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
import ch.studihome.jspserver.model.pojos.SignupForm;

@Controller
public class RegisterController {

    @Autowired
    SignupService sampleService;


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
    	ModelAndView model = new ModelAndView("register");
    	model.addObject("signupForm", new SignupForm());    	
        return model;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ModelAndView create(@Valid SignupForm signupForm, BindingResult result, RedirectAttributes redirectAttributes) {
    	
    	ModelAndView model; 
    	
    	if (!signupForm.getPassword().equals(signupForm.getConfirmPassword())) {
        	model = new ModelAndView("register");
        	model.addObject("signupForm", new SignupForm());    	
        	model.addObject("error", "Passwords not matching");
    	} else if (!result.hasErrors()) {
            try {
            	sampleService.saveFrom(signupForm);
            	model = new ModelAndView("index");
            } catch (InvalidUserException e) {
            	model = new ModelAndView("register");
            	model.addObject("page_error", e.getMessage());
            }
        } else {
        	model = new ModelAndView("register");
        }   	
    	return model;
    }
    
    @RequestMapping(value = "/security-error", method = RequestMethod.GET)
    public String securityError(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("page_error", "You do have have permission to do that!");
        return "redirect:/";
    }

}


