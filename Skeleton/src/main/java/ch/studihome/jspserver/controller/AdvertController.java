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
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.BSalert;

/**
 * Load and return advert view 
 * 
 * @author TeamSix
 */


@Controller
public class AdvertController {
	static Logger log = Logger.getLogger(AdvertController.class.getName());
    
	@Value("${path.adimg}")
	private String imgPath;
    
    @Autowired
    AdService adService;
    
    @Autowired
    UserDao usrDao;
    
    @Autowired
    AdvertDao advDao;
    
    public AdvertController() {}
    
    
    public AdvertController(AdService adService, UserDao usrDao, AdvertDao advDao)
    {
		this.adService = adService;
		this.usrDao = usrDao;
		this.advDao = advDao;
	}



    /**
     * 
     * @param advId Id of the advert in the DB
     * @param principal User object
     * @return model containing advert view
     */
    @RequestMapping(value = "/advert", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam(value = "id", required=false)String advId, Principal principal)
    {
    	ModelAndView model = new ModelAndView("advert");
    	
    	if(advId == null) // new ad
    	{
    		if (principal != null)
    		{
    			model.addObject("editable", "true");
    			model.addObject("adForm", new AdForm());
    		}else
    		{
    			model = new ModelAndView("infoPage");
    			model.addObject("title", "Advert - Error 403");
    			BSalert[] alerts = new BSalert[1];
            	alerts[0] = new BSalert(BSalert.Type.warning, "You don't have the permission to access 'Advert - edit'");
            	model.addObject("alerts", alerts);
    		}
    	}else
    	{
    		AdForm adForm = adService.loadById(advId);
    		if(adForm == null)
    		{
    			model = new ModelAndView("infoPage");
    			model.addObject("title", "Advert - Error 404");
    			BSalert[] alerts = new BSalert[1];
            	alerts[0] = new BSalert(BSalert.Type.warning, "Ups, the advert " + advId + " could not be found.");
            	model.addObject("alerts", alerts);
    		}else
    		{
    			if (principal != null) {
    				User user = usrDao.findByUserName(principal.getName());
    				Advert adv = advDao.findOne(adForm.getId());
    				if(user.getusrId() == adv.getUser().getusrId()) {     			
    					model.addObject("editable", "true");
    				}else {
        				model.addObject("editable", "false");
        			}
    			}else {
    				model.addObject("editable", "false");
    			}
		    	model.addObject("adForm", adForm);
    		}
    	}
    	log.info("Returning advert model");
    	return model;
    }
    
    /**
     * 
     * @param adForm Form to validate data integrity with advert object
     * @param result Return of the form validation.
     * @param redirectAttributes For user information
     * @param principal User object 
     * @return
     */
    @RequestMapping(value = "/advert", method = RequestMethod.POST)
    public ModelAndView save(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes, Principal principal)
    {
    	boolean noAccess = false;
    	
    	log.info("Receiving form. Checking ...");
    	ModelAndView model = new ModelAndView("advert");
    	
    	if (principal != null)
		{

			User user = usrDao.findByUserName(principal.getName());
			Advert adv = advDao.findOne(adForm.getId());
			if(adForm.getId() == 0 || user.getusrId() == adv.getUser().getusrId())
			{
		    	if(!result.hasErrors())
		    	{
		    		try {
		        		adForm.setOwnerId(user.getusrId());
		            	adForm = adService.saveFrom(adForm);
		            	BSalert[] alerts = new BSalert[1];
		            	alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Ad saved.");
		            	model.addObject("alerts", alerts);
		            	
		        		log.info("Saved object in db");
		    		} catch (ImageSaveException e) {
		    			log.info("Error while saving ad to db");
		
		            	BSalert[] alerts = new BSalert[1];
		            	alerts[0] = new BSalert(BSalert.Type.danger, "<strong>Error!</strong> " + e.getMessage());
		            	model.addObject("alerts", alerts);
		    		}
		    		
		        }else {
		        	log.info("Error in form: " + result.getAllErrors().toString() + "/nReturning new one.");
		        }
		    	
		    	model.addObject("editable", "true");
		    	model.addObject("adForm", adForm);
			}else
			{
				noAccess = true;
			}
		}else
		{
			noAccess = true;
		}
		
    	if(noAccess)
		{
			model = new ModelAndView("infoPage");
	    	model.addObject("title", "Access denied!");
	    	BSalert[] alerts = new BSalert[1];
	    	alerts[0] = new BSalert(BSalert.Type.danger, "You don't have the permission to change the advert '" + adForm.getTitle() + "'");
	    	model.addObject("alerts", alerts);
		}
    	
    	return model;
    }

}


