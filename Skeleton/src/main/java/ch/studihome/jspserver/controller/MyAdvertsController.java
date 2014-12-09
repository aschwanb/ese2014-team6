package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;

/**
 * Load and return myAdverts view 
 * 
 * @author TeamSix
 */
@Controller
public class MyAdvertsController {

	@Autowired MyUserDetailsService userService;
	
	/**
	 * 
	 * @return myAdverts view 
	 */
	@RequestMapping(value = "/myAdverts", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("myAdverts");
    	User user = userService.getUser();
    	model.addObject("user", user);
    	
    	// Ads		
    	Advert[] ads = new Advert[0];
    	ads = user.getAds().toArray(ads);
    	model.addObject("ads", ads);

    	return model;
    }

}


