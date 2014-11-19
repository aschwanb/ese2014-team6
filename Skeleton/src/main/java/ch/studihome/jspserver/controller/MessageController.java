package ch.studihome.jspserver.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Handle message editing and sending
 * 
 * @author TeamSix
 */
@Controller
public class MessageController {

    @Autowired MessageDao messageDao;
    @Autowired AdvertDao advertDao;
	
	/**
     * 
     * @return Edit form
     */
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public ModelAndView messageTo() {
    	
		ModelAndView model = new ModelAndView("contact");
		return model;
    }
	
	@RequestMapping(value = { "/test", "/msgTest" }, method = RequestMethod.GET)
	public ModelAndView newMessageTest(){
		ModelAndView model = new ModelAndView("msgTest");
		model.addObject("messageForm", new MessageForm());
		return model;
	}
	
	@RequestMapping(value = { "/test", "/msgTest" }, method = RequestMethod.POST)
	public ModelAndView displayMessage(
			@Valid MessageForm message,
			BindingResult result
			){
		
		ModelAndView model = new ModelAndView("msgTest");

		if(!result.hasErrors()) {
			//Todo: Save Message. Catch User not found
			model.addObject("messageForm", new MessageForm());
			model.addObject("message", message);

		} else {
			model.addObject("messageForm", message);
		}
		return model;
	}

}


