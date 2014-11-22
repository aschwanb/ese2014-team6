package ch.studihome.jspserver.controller;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Handle message editing and sending
 * 
 * @author TeamSix
 */
@Controller
public class MessageController {

    @Autowired MessageDao messageDao;
    @Autowired MessageService messageService;
	static Logger log = Logger.getLogger(AdvertController.class.getName());
	
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
	public ModelAndView saveMsg(
			@Valid MessageForm messageForm,
			BindingResult result,
			RedirectAttributes redirectAttributes
			){
		ModelAndView model = new ModelAndView("msgTest");
		BSalert[] alerts = new BSalert[1];

		if(!result.hasErrors()) {
			log.info("Form valid");
			try {
				messageForm = messageService.saveMessage(messageForm);
            	alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Message send.");
				model.addObject("message", messageForm.toString());
				
				log.info("Message saved in db");            					
			} catch (InvalidUserException e) {
				log.info("User not found");				
            	alerts[0] = new BSalert(BSalert.Type.danger, "<strong>Error!</strong> " + e.getMessage());
			}

		} else {
			//TODO: Display error message
			log.info("Form invalide. Error handling started");
		}

		model.addObject("messageForm", messageForm);  	
		model.addObject("alerts", alerts);
		return model;
	}

}


