package ch.studihome.jspserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.SearchForm;
import ch.studihome.jspserver.model.pojos.SignupForm;
/**
 * Load and return register view 
 * 
 * @author TeamSix
 */
@Controller
public class RegisterController {

    @Autowired SignupService signupService;
    @Autowired MyUserDetailsService userDetailsService;
    @Autowired AdService adService;
	@Value("${path.adimg}") private String imgPath;	

    
/**
 * 
 * @return register view
 */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
    	ModelAndView model = new ModelAndView("register");
    	model.addObject("signupForm", new SignupForm());    	
        return model;
    }

    /**
     * Most method 
     * @param signupForm Form to validate integrity with user object
     * @param result Return of form validation
     * @param redirectAttributes to inform user
     * @return
     */
    
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView create(
    		@Valid SignupForm signupForm,
    		BindingResult result,
    		RedirectAttributes redirectAttributes
    		) {
    	
    	ModelAndView model = new ModelAndView(); 
    	
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
    	    	BSalert[] alerts = new BSalert[1];
    	    	alerts[0] = new BSalert(BSalert.Type.success, "Sign Up Complete! Welcome to StudiHome, " 
    	    			+ signupForm.getFirstName() + " " + signupForm.getLastName());
    	    	model.addObject("alerts", alerts);
    	    	
//            	Login user
    	    	User user = userDetailsService.loadUserByUsername(signupForm.getUserName());
    	    	UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user, signupForm.getPassword(), user.getAuthorities());
    	    	SecurityContextHolder.getContext().setAuthentication(auth);
    	    	
//    	    	TODO: This should be a proper redirect
    	    	Iterable<Advert> ads = adService.findAll();
    	    	model = new ModelAndView("index");
    	    	model.addObject("alerts", alerts);
    	    	model.addObject("ads", ads);
    	    	model.addObject("imgPath", imgPath);
    	    	model.addObject("searchForm", new SearchForm());
    	    	
    	    	
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


