package ch.studihome.jspserver.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;

@Controller
public class AdpageController {
	static Logger log = Logger.getLogger(AdpageController.class.getName());
    
	@Value("${path.adimg}")
	private String imgPath;
    
    @Autowired
    AdService adService;
    
    @Autowired
    UserDao usrDao;

    @RequestMapping(value = "/adpage", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam(value = "id", required=false)String advId, Principal principal)
    {
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if(advId == null) // new ad
    	{
	    	model.addObject("editable", "true");
	    	model.addObject("adForm", new AdForm());
    	}else
    	{
    		AdForm adForm = adService.loadById(advId);
    		if(adForm == null)
    		{
    			model = new ModelAndView("error");
    			model.addObject("errortext", "Ups, the advert " + advId + " could not be found.");
    		}else
    		{
    			User user = usrDao.findByEmail(principal.getName()).get(0);
    			if(user.getId() == Long.decode(adForm.getOwnerId()))	//TODO better
    			{
    				model.addObject("editable", "true");
    			}else
    			{
    				model.addObject("editable", "false");
    			}
		    	model.addObject("adForm", adForm);
    		}
    	}
    	log.info("Returning adpage model");
    	return model;
    }
    
    @RequestMapping(value = "/saveAdvert", method = RequestMethod.POST)
    public ModelAndView save(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes, Principal principal)
    {
    	log.info("Receiving form. Checking ...");
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if(!result.hasErrors())
    	{
    		try {
    			User user = usrDao.findByEmail(principal.getName()).get(0);
        		adForm.setOwnerId(user.getId().toString());
            	adForm = adService.saveFrom(adForm);
            	model.addObject("alertGood", "Ad saved.");
            	
        		log.info("Saved object in db");
    		} catch (ImageSaveException e) {
    			log.info("Error while saving ad to db");
    			
    			model.addObject("alertError", e.getMessage());
    		}
    		
        }else {
        	log.info("Error in form. Returning new one");
        }
    	
    	model.addObject("editable", "true");
    	model.addObject("adForm", adForm);
    	return model;
    }

}


