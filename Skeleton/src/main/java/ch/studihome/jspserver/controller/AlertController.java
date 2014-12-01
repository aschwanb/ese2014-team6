package ch.studihome.jspserver.controller;

import java.util.HashSet;

import javax.validation.Valid;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.SearchForm;

/**
 * Load and return user profile view 
 * 
 * @author TeamSix
 */
@Controller
public class AlertController {

	/**
	 * 
	 * @return alerts view 
	 */
	@RequestMapping(value = "/alerts", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("alerts");
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	model.addObject("user", user);
    	
    	// Alerts		
    	Alert[] alerts = new Alert[0];
    	alerts = user.getAlerts().toArray(alerts);
    	model.addObject("alerts", alerts);

    	return model;
    }

	@RequestMapping(value = "/setalert", method = RequestMethod.POST)
    public ModelAndView setAlert(@Valid SearchForm searchForm)
    {
    	ModelAndView model = new ModelAndView("ajaxAnswer");
    	
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	model.addObject("user", user);
    	
    	//save alert to database
    	HashSet<Alert> alerts = (HashSet<Alert>) user.getAlerts();
    	Alert alert = new Alert();
    	alert.setUser(user);
    	alert.setMin_price(searchForm.getMin_price());
    	alert.setMax_price(searchForm.getMax_price());
    	alert.setMin_room_size(searchForm.getMin_room_size());
    	alert.setMax_room_size(searchForm.getMax_room_size());
    	alert.setMin_appartment_size(searchForm.getMin_appartment_size());
    	alert.setMax_appartment_size(searchForm.getMax_appartment_size());
    	alert.setMin_number_of_inhabitants(searchForm.getMin_number_of_inhabitants());
    	alert.setMax_number_of_inhabitants(searchForm.getMax_number_of_inhabitants());
    	alert.setArea(searchForm.getArea());
    	alert.setType_of_apartment(searchForm.getType_of_apartment());
    	
    	alerts.add(alert);
    	user.setAlerts(alerts);
    	//TODO Save User
    	
    	
    	model.addObject("alerts", "success");

    	return model;
    }

}


