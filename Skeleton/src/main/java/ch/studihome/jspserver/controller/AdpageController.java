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

@Controller
public class AdpageController {
	static Logger log = Logger.getLogger(AdpageController.class.getName());
    
	@Value("${path.adimg}")
	private String imgPath;
    
    @Autowired
    AdService adService;
    
    @Autowired
    UserDao usrDao;
    
    @Autowired
    AdvertDao advDao;

    @RequestMapping(value = "/advert", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam(value = "id", required=false)String advId, @RequestParam(required=false)Principal principal)
    {
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if(advId == null) // new ad
    	{
    		if (principal != null)
    		{
    			model.addObject("editable", "true");
    			model.addObject("adForm", new AdForm());
    		}else
    		{
    			model = new ModelAndView("noAccess");
    			model.addObject("msg", "You don't have the permission to access 'Adpage - edit'");
    		}
    	}else
    	{
    		AdForm adForm = adService.loadById(advId);
    		if(adForm == null)
    		{
    			model = new ModelAndView("error");
    			model.addObject("errortext", "Ups, the advert " + advId + " could not be found.");
    		}else
    		{
    			if (principal != null) {
    				User user = usrDao.findByEmail(principal.getName()).get(0);
    				Advert adv = advDao.findOne(adForm.getId());
    				if(user.getUsr_id() == adv.getUser().getUsr_id()) {     			
    					model.addObject("editable", "true");
    				}
    			}else {
    				model.addObject("editable", "false");
    			}
		    	model.addObject("adForm", adForm);
    		}
    	}
    	log.info("Returning adpage model");
    	return model;
    }
    
    @RequestMapping(value = "/advert", method = RequestMethod.POST)
    public ModelAndView save(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes, Principal principal)
    {
    	boolean noAccess = false;
    	
    	log.info("Receiving form. Checking ...");
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if (principal != null)
		{

			User user = usrDao.findByEmail(principal.getName()).get(0);
			Advert adv = advDao.findOne(adForm.getId());
			if(adForm.getId() == 0 || user.getUsr_id() == adv.getUser().getUsr_id())
			{
		    	if(!result.hasErrors())
		    	{
		    		try {
		        		adForm.setOwnerId(user.getUsr_id().toString());
		            	adForm = adService.saveFrom(adForm);
		            	BSalert[] alerts = new BSalert[3];
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
		        	log.info("Error in form. Returning new one");
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
			model = new ModelAndView("noAccess");
			model.addObject("msg", "You don't have the permission change the advert '" + adForm.getTitle() + "'");
		}
    	
    	return model;
    }

}


