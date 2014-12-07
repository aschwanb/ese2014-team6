package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.BookmarkDao;
import ch.studihome.jspserver.model.dao.UserDao;

/**
 * Functionality for bookmarking adverts
 * 
 * @author TeamSix
 */
@Controller
public class BookmarkController {
	
	@Autowired UserDao usrDao;
    @Autowired AdvertDao advDao;
    @Autowired MyUserDetailsService userService;
    
    @Autowired
    BookmarkDao bmDao;

    /**
     * Shows the Bookmarks page
     * @return bookmarks page model
     */
    @RequestMapping(value = "/bookmarks", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("bookmarks");
    	
    	User user = userService.getUser();
    	model.addObject("user", user);
    	
    	// Bookmarks
    	Bookmark[] bms = new Bookmark[0];
    	bms = user.getBookmarks().toArray(bms);
    	model.addObject("bookmarks", bms);
    	
    	return model;
    }
    
    /**
	 * Bookmarks a given ad
	 * @return ajax response page
	 */
    @RequestMapping(value = "bookmark", method = RequestMethod.GET)
    public ModelAndView setBookmark(@RequestParam(value = "id", required=false)Long advId) {
    	ModelAndView model = new ModelAndView("ajaxAnswer");
    	
    	User user = userService.getUser();
    	
    	if(advId == null)
    	{
        	model.addObject("content", "invalid request");
    	}else if(user == null)
    	{
    		model.addObject("content", "you must be signed in to bookmark adverts");
    	}else
    	{
    		Advert adv = advDao.findOne(advId);
    		
    		Bookmark bm = bmDao.findByAdvertAndUser(adv, user);
    		
    		if(bm == null)
    		{
    			bm = new Bookmark(user, adv, false);
    			bmDao.save(bm);
    			
        		model.addObject("content", "success");
    		}else
    		{
        		model.addObject("content", "already");
    		}
    		
    	}
    	
    	return model;
    }
    
    /**
	 * Marks a given ad as "interested in"
	 * @return ajax response page
	 */
    @RequestMapping(value = "showinterest", method = RequestMethod.GET)
    public ModelAndView setInterest(@RequestParam(value = "id", required=false)Long advId) {
    	ModelAndView model = new ModelAndView("ajaxAnswer");
    	
    	User user = userService.getUser();
    	
    	if(advId == null)
    	{
        	model.addObject("content", "invalid request");
    	}else if(user == null)
    	{
    		model.addObject("content", "you must be signed in to show interest in an advert");
    	}else
    	{
    		Advert adv = advDao.findOne(advId);
    		
    		Bookmark bm = bmDao.findByAdvertAndUser(adv, user);
    		
    		if(bm == null)
    		{
    			bm = new Bookmark(user, adv, true);
    			bmDao.save(bm);
    			
        		model.addObject("content", "success");
    		}else if(!bm.getInterested())
    		{
    			bm.setInterested(true);
    			bmDao.save(bm);
    			
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


