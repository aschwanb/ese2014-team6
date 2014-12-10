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
import ch.studihome.jspserver.controller.service.InviteService;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Calendar;
import ch.studihome.jspserver.model.Event;
import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.CalendarDao;
import ch.studihome.jspserver.model.dao.EventDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.InvitationForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * The invite controller is handling invites 
 * 
 * @author TeamSix
 */
@Controller
public class InviteController {

    @Autowired InviteDao inviteDao;
    @Autowired InviteService inviteService;
    @Autowired AdvertDao advertDao;
    @Autowired UserDao userDao;
    @Autowired MessageDao messageDao;
    @Autowired CalendarDao calendarDao;
    @Autowired EventDao eventDao;
    
    public InviteController(){}
    
	public InviteController(InviteDao inviteDao, InviteService inviteService,
			AdvertDao advertDao, UserDao userDao, MessageDao messageDao,
			CalendarDao calendarDao, EventDao eventDao)
	{
		this.inviteDao = inviteDao;
		this.inviteService = inviteService;
		this.advertDao = advertDao;
		this.userDao = userDao;
		this.messageDao = messageDao;
		this.calendarDao = calendarDao;
		this.eventDao = eventDao;
	}



	static Logger log = Logger.getLogger(AdvertController.class.getName());
	
	/**
	 * 
	 * This method is called if a user reacts to an invitation
	 * by clicking on the hyperlink.
	 * Two optiona are possible:
	 * The user rejects the invitation. Noting happens.
	 * The user accepts the invitation. An event is added to his
	 * calendar and to the calendar of the user, who invited him.
	 * 
	 *  In both cases, the invitation is marked as reacted to in 
	 *  order to make it impossible for the user to ad the same event
	 *  to his calendar several times.
	 *
	 * @param msgId: Message ID to find information in database
	 * @param confirm: Type of reaction (Deny or accept)
	 * @return
	 */
	@RequestMapping(value = "/invited", method = RequestMethod.GET)
	public ModelAndView inviteReact(
			@RequestParam(value = "msgId", required = true)Long msgId,
			@RequestParam(value = "confirm", required = true)Boolean confirm
			){
		ModelAndView model = new ModelAndView("message");
		User fromUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User toUser = messageDao.findById(msgId).getFromUser();
		BSalert[] alerts = new BSalert[1];
		
		Invite invite = inviteDao.findById(msgId);
		if (invite.getReacted()) {
			alerts[0] = new BSalert(BSalert.Type.success, "<strong>Error!</strong> You allready reacted to this invitation.");			
		} else {
			if (confirm) {
	        	alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Invitation confirmed.");
	        	// Add event to calendar for both users
	        	User[] users = new User[] {fromUser, toUser};
	        	for (User user: users) {
	        		Event event = new Event(invite);
	        		Calendar calendar = user.getCalendar();
	        		calendar.addEvent(event);
	        		calendarDao.save(calendar);
	        		eventDao.save(event);
	        		userDao.save(user);
	        	}
			} else {
	        	alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Invitation rejected.");
	        	// TODO: Inform other party
			}
			invite.setReacted(true);
		}

		inviteDao.save(invite);
		model.addObject("msg", messageDao.findById(msgId));  	
		model.addObject("alerts", alerts);
        model.addObject("fromUser", fromUser);
		model.addObject("toUser", toUser);
		return model;
	}


	/**
	 * 
	 * Return view and form to generate an invitation to
	 * a specific user.
	 * @param usrId: Which user shall be invited?
	 * @param adId: Which invitation is this invite about.
	 * @return
	 */
	@RequestMapping(value = { "/invite" }, method = RequestMethod.GET)
    public ModelAndView invite(
    		@RequestParam(value = "usrId", required = true)Long usrId,
    		@RequestParam(value = "adId", required = true)Long adId
    		) {
				
		ModelAndView model = new ModelAndView("invite");
		User fromUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User toUser = userDao.findByUsrId(usrId);
		
        model.addObject("invitationForm", new InvitationForm());
        model.addObject("fromUser", fromUser);
		model.addObject("toUser", toUser);
		model.addObject("usrId", usrId);
		model.addObject("adId", adId);
		return model;
    }
	
	/**
	 * If the form is valid, an invitation is generated.
	 * Otherwise, an error is returned.
	 * 
	 * @param invitationForm
	 * @param result
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/invite", method = RequestMethod.POST)
	public ModelAndView getInvite(
			@Valid InvitationForm invitationForm,
			BindingResult result,
			RedirectAttributes redirectAttributes
			) {
		ModelAndView model = new ModelAndView("invite");
		BSalert[] alerts = new BSalert[1];
		
		if (!result.hasErrors()) {
			try {
				invitationForm = inviteService.saveInvite(invitationForm);
				alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Invitation send.");
		
			} catch (InvalidUserException e) {
            	alerts[0] = new BSalert(BSalert.Type.danger, "<strong>Error!</strong> " + e.getMessage());
			}
		} else {
//			TODO: Proper error handling
		}
		model.addObject("invitationForm", invitationForm);
		model.addObject("alerts", alerts);
		return model;
		
	}
}


