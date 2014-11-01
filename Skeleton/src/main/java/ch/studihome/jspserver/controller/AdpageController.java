package ch.studihome.jspserver.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.model.pojos.AdForm;

@Controller
public class AdpageController {
	static Logger log = Logger.getLogger(AdpageController.class.getName());
    
	@Value("${path.adimg}")
	private String imgPath;
    
    @Autowired
    AdService adService;

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
    			log.info("principal: " + principal.getName() + " owner: " + adForm.getOwnerEmail());
    			if(principal.getName().equals(adForm.getOwnerEmail()))	//TODO better
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
    	ModelAndView model;
    	
    	if(!result.hasErrors())
    	{
    		// Save image
			try {
				MultipartFile image = adForm.getImage();
				String imagePath = imgPath + image.getOriginalFilename();
				byte[] bytes = image.getBytes();
				BufferedOutputStream stream = 
						new BufferedOutputStream(
								new FileOutputStream(new File(imagePath)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				log.info(e.toString());
				return model = new ModelAndView("adpage");
			}
    		adForm.setOwnerEmail(principal.getName());
        	adForm = adService.saveFrom(adForm);
        	model = new ModelAndView("profilepage");
        }else {
        	log.info("Error in form. Returning new one");
        	model = new ModelAndView("adpage");
        	model.addObject("editable", "true");
        	model.addObject("adForm", adForm);

        }
    	return model;
    }

}


