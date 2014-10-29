package org.sample.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.validation.Valid;

import org.sample.controller.pojos.AdForm;
import org.sample.controller.service.AdLoadService;
import org.sample.controller.service.AdSaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdpageController {
	
    @Autowired
    AdSaveService adSaveService;
    
    @Autowired
    AdLoadService adLoadService;

    @RequestMapping(value = "/adpage", method = RequestMethod.GET)
    public ModelAndView show(@RequestParam(value = "id", required=false)String advId)
    {
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if(advId == null) // new ad
    	{
	    	model.addObject("editable", "true");
	    	model.addObject("adForm", new AdForm());
    	}else
    	{
    		AdForm adForm = adLoadService.loadById(advId);
    		if(adForm == null)
    		{
    			model = new ModelAndView("error");
    			model.addObject("errortext", "Ups, the advert " + advId + " could not be found.");
    		}else
    		{
    			if(adForm.getOwnerEmail().equals("owner"))	//TODO
    			{
    				model.addObject("editable", "true");
    			}else
    			{
    				model.addObject("editable", "false");
    			}
		    	model.addObject("adForm", adForm);
    		}
    	}
    	
    	return model;
    }
    
    @RequestMapping(value = "/saveAdvert", method = RequestMethod.POST)
    public ModelAndView save(@Valid AdForm adForm, BindingResult result, RedirectAttributes redirectAttributes)
    {
    	ModelAndView model = new ModelAndView("adpage");
    	
    	if(!result.hasErrors())
    	{
    		// Save image
			try {
				MultipartFile image = adForm.getImage();
				String imgPath = "user/ad/img/" + image.getOriginalFilename() + "-uploaded";
				byte[] bytes = image.getBytes();
				BufferedOutputStream stream = 
						new BufferedOutputStream(
								new FileOutputStream(new File(imgPath)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				return model;
			}
        	adForm = adSaveService.saveFrom(adForm);
        }else
        {
        }
    	
    	model.addObject("editable", "true");
    	model.addObject("adForm", adForm);
    	return model;
    }

}


