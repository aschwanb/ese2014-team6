package ch.studihome.jspserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;

/**
 * Load and return index view 
 * 
 * @author TeamSix
 */
@Controller
public class IndexController {

    // Image location = imgPath + imageName
	@Value("${path.adimg}") private String imgPath;	
    @Autowired SignupService sampleService;
    @Autowired AdService adService;

    public IndexController() {}
    
    
    
    public IndexController(AdService adService)
    {
		this.adService = adService;
	}
	
	/**
     * 
     * @return Index view
     */
	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index() {
    	
    	Iterable<Advert> ads = adService.findAll();
    	ModelAndView model = new ModelAndView("index");
    	model.addObject("ads", ads);
    	model.addObject("imgPath", imgPath);
    	return model;
    	
    }

}


