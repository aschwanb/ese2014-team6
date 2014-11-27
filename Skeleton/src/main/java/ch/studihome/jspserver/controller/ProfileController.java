package ch.studihome.jspserver.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;

/**
 * Load and return user profile view 
 * 
 * @author TeamSix
 */
@Controller
public class ProfileController {
	
	@Autowired
    UserDao usrDao;
	
	public ProfileController() {}
		
    public ProfileController(UserDao usrDao)
    {
		this.usrDao = usrDao;
	}

	/**
	 * 
	 * @param principal User object
	 * @return Profile view
	 */
	@RequestMapping(value = "/profile", method = RequestMethod.GET)
    public ModelAndView index(Principal principal)
    {
    	ModelAndView model = new ModelAndView("profile");
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	model.addObject("user", user);
    	
    	// Ads		
    	Advert[] ads = new Advert[0];
    	ads = user.getAds().toArray(ads);
    	model.addObject("ads", ads);
    	
    	// Bookmarks
    	Advert[] bms = new Advert[0];
    	bms = user.getBookmarks().toArray(bms);
    	model.addObject("bookmarks", bms);
    	
    	// Messages
    	ArrayList<Message> msgs = new ArrayList<Message>();
    	msgs.addAll(user.getToMsgs());
//    	Uncomment to display messages send by this user
//    	msgs.addAll(user.getFromMsgs());
    	// Sorting messages according to date
    	Collections.sort(msgs, new Comparator<Message>() {
    		public int compare(Message msg1, Message msg2) {
    			return -1 * msg1.getDate().compareTo(msg2.getDate()); // Oldest last
    		}
    	});
    	
    	model.addObject("msgs", msgs);
//    	Todo:
//    		Calendar

    	return model;
    }

}


