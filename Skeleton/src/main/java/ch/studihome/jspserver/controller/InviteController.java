package ch.studihome.jspserver.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Calendar;
import ch.studihome.jspserver.model.Event;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.InvitationForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Handle message editing and sending
 * 
 * @author TeamSix
 */
@Controller
public class InviteController {

    @Autowired MessageDao messageDao;
    @Autowired MessageService messageService;
    @Autowired AdvertDao advertDao;
    @Autowired UserDao userDao;
    
	static Logger log = Logger.getLogger(AdvertController.class.getName());
	
	@RequestMapping(value = { "/test" }, method = RequestMethod.GET)
    public ModelAndView messageToAdvertiser(
    		@RequestParam(value = "usrId", required = false)Long usrId
    		) {
				
		ModelAndView model = new ModelAndView("test");
//		User fromUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//		User toUser = userDao.findByUsrId(usrId);
		
        model.addObject("invitationForm", new InvitationForm());
        Event event1 = new Event("2/12/2014", "SPORT and WELLNESS", "http://bic.cat", 
        		"<img src=\"http://gettingcontacts.com/upload/jornadas/sport-wellness_portada.png\" ><br>06-11-2013 - 09:00 <br> Tecnocampus Mataró Auditori");
        Event event2 = new Event("20/11/2014", "SPORT and WELLNESS", "http://bic.cat", 
        		"<img src=\"http://gettingcontacts.com/upload/jornadas/sport-wellness_portada.png\" ><br>06-11-2013 - 09:00 <br> Tecnocampus Mataró Auditori");
        ArrayList<Event> events = new ArrayList<Event>();
        events.add(event1);
        events.add(event2);
        Calendar calendar = new Calendar(events);
        model.addObject("calendar", calendar);
//      model.addObject("fromUser", fromUser);
//		model.addObject("toUser", toUser);
		        
		return model;
    }
}


