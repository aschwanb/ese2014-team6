package ch.studihome.jspserver.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.AlertService;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.SearchForm;

/**
 * Load and return user profile view 
 * 
 * @author TeamSix
 */
@Controller
public class AlertController {
	
	@Autowired AlertService alertService;
	@Autowired MyUserDetailsService userService;
	
	public AlertController(){}
	
	public AlertController(AlertService alertService,
			MyUserDetailsService userService)
	{
		this.alertService = alertService;
		this.userService = userService;
	}



	/**
	 * 
	 * @return alerts view 
	 */
	@RequestMapping(value = "/alerts", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("alerts");
    	
    	User user = userService.getUser();
    	model.addObject("user", user);
    	
    	// Alerts		
    	Alert[] alerts = new Alert[0];
    	alerts = user.getAlerts().toArray(alerts);
    	model.addObject("aalerts", alerts);

    	return model;
    }

	@RequestMapping(value = "/setalert", method = RequestMethod.POST)
    public ModelAndView setAlert(@Valid SearchForm searchForm)
    {
    	ModelAndView model = new ModelAndView("ajaxAnswer");
    	
        User user = userService.getUser();
    	
        alertService.addAlert(searchForm, user);
        
    	model.addObject("content", "success");

    	return model;
    }

}


