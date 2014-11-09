package ch.studihome.jspserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;

@Controller
public class ProfileController {
	
	@Autowired
    UserDao usrDao;
	
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView index(Principal principal)
    {
    	ModelAndView model = new ModelAndView("profile");
    	
    	User user = usrDao.findByEmail(principal.getName()).get(0);
    	
    	Advert[] ads = new Advert[0];
    	ads = user.getAds().toArray(ads);
    	
    	model.addObject("ads", ads);
    	
    	return model;
    }

}


