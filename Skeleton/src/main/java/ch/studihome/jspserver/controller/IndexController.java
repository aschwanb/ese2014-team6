package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;

@Controller
public class IndexController {

    @Autowired SignupService sampleService;
    @Autowired AdService adService;
    // Autowired is not working for AdServiceImpl
//    AdServiceImpl adService = new AdServiceImpl();
    
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() {
    	
    	Iterable<Advert> ads = adService.findAll();
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("ads", ads);    	
    	return model;
    	
//    	getId();
//    	getTitle();
//    	getPrice();
    }

}


