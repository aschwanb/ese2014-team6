package ch.studihome.jspserver.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.BSalert;

/**
 * Functionality for bookmarking adverts
 * 
 * @author TeamSix
 */
@Controller
public class BookmarkController {
	
	@Autowired
    UserDao usrDao;
    
    @Autowired
    AdvertDao advDao;
	
    /**
	 * 
	 * @param user User object
	 * @return access denied page
	 */
    @RequestMapping(value = "bookmark", method = RequestMethod.GET)
    public ModelAndView noAccess(@RequestParam(value = "id", required=false)Long advId, Principal principal) {
    	ModelAndView model = new ModelAndView("ajaxAnswer");
    	
    	if(advId == null)
    	{
        	model.addObject("content", "invalid request");
    	}else if(principal == null)
    	{
    		model.addObject("content", "you must be signed in to bookmark adverts");
    	}else
    	{
    		Advert adv = advDao.findOne(advId);
    		User user = usrDao.findByEmail(principal.getName()).get(0);
    		
    		if(!user.getBookmarks().contains(adv))
    		{
    			user.getBookmarks().add(adv);
    			usrDao.save(user);
        		model.addObject("content", "success");
    		}else
    		{
        		model.addObject("content", "already");
    		}
    		
    	}
    	
    	return model;
    }

    /* Add other specialized Request handling for infoPage here */
}


