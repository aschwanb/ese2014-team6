package ch.studihome.jspserver.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.validation.Valid;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
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
    @Autowired AdvertDao advertDao;
    @Autowired UserDao userDao;
    @Autowired MyUserDetailsService userService;
    
	static Logger log = Logger.getLogger(AdvertController.class.getName());
	
	public MessageController(){}
	
	public MessageController(MessageDao messageDao,
			MessageService messageService, AdvertDao advertDao,
			UserDao userDao, MyUserDetailsService userService)
	{
		this.messageDao = messageDao;
		this.messageService = messageService;
		this.advertDao = advertDao;
		this.userDao = userDao;
		this.userService = userService;
	}


	/**
     * Shows the messages page which holds
     * a list of all the messages send to the user
     * @return messages page model
     */
    @RequestMapping(value = "/messages", method = RequestMethod.GET)
    public ModelAndView index()
    {
    	ModelAndView model = new ModelAndView("messages");
    	User user = userService.getUser();    	
    	model.addObject("user", user);
    	
    	// Messages
    	ArrayList<Message> msgs = new ArrayList<Message>();
    	msgs.addAll(user.getToMsgs());
//    	Uncomment to display messages send by this user
//    	msgs.addAll(user.getFromMsgs());
    	// Sorting messages according to date
    	Collections.sort(msgs, new Comparator<Message>() {
    		public int compare(Message msg1, Message msg2) {
    			return -1 * msg1.getDate().compareTo(msg2.getDate()); // Oldest last
    		}
    	});
    	model.addObject("msgs", msgs);
    	
    	return model;
    }
	
    /**
     * This controler return a form to create a message to 
     * an user. Depending on where the controller was
     * called from, it has different parameters to determin,
     * who the message is send to.
     * 
     * @param advId: Message is send to the owner of the advert.
     * @param usrId: Message is send to the user with this id.
     * @param msgId: Message is send to the owner of the message.
     * @return Message edit view
     */
	@RequestMapping(value = { "/contact" }, method = RequestMethod.GET)
    public ModelAndView messageToAdvertiser(
    		@RequestParam(value = "advId", required = false)Long advId,
    		@RequestParam(value = "usrId", required = false)Long usrId,
    		@RequestParam(value = "msgId", required = false)Long msgId
    		) {
				
		ModelAndView model = new ModelAndView("contact");
		User fromUser = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		User toUser = new User();
		if (advId != null) {
			toUser = advertDao.findByAdvId(advId).getUser();
		} else if (usrId != null) {
			toUser = userDao.findByUsrId(usrId);
		} else if (msgId != null) {
			toUser = messageDao.findById(msgId).getFromUser();
			model.addObject("MsgId", msgId);
		} else {
			throw new InvalidUserException("No valide User ID could be determined");
		}
		
        model.addObject("messageForm", new MessageForm());
        model.addObject("fromUser", fromUser);
		model.addObject("toUser", toUser);
        
		return model;
    }
	
	/**
	 * 
	 * Validate the message and create a message object.
	 * If an error occurs, the user is informed.
	 * 
	 * @param messageForm
	 * @param result
	 * @param redirectAttributes
	 * @param msgId
	 * @return
	 */
	@RequestMapping(value = { "/contact" }, method = RequestMethod.POST)
	public ModelAndView messagePost(
			@Valid MessageForm messageForm,
			BindingResult result,
			RedirectAttributes redirectAttributes,
    		@RequestParam(value = "msgId", required = false)Long msgId			
			){
		ModelAndView model = new ModelAndView("contact");
		BSalert[] alerts = new BSalert[1];

		if(!result.hasErrors()) {
			log.info("Form valid");
			try {
				messageForm = messageService.saveMessage(messageForm);
            	alerts[0] = new BSalert(BSalert.Type.success, "<strong>Success!</strong> Message send.");
				model.addObject("message", messageForm.toString());
				
				log.info("Message saved in db"); 
				if (msgId != null) {
					Message oldMessage = messageDao.findById(msgId);
					oldMessage.setHasResponded(true);
					messageDao.save(oldMessage);
					log.info("Message marked as responded to in db. Message " + oldMessage.getId());
					
				}
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
	
	/**
	 * Return detail view for a message.
	 * If the message is looked at for the first time,
	 * it is marked as read in the database.
	 * 
	 * @param id: Message id.
	 * @return Message detail view
	 */
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public ModelAndView messageShow(
			@RequestParam(value = "id", required = true)Long id
			) {
		ModelAndView model = new ModelAndView("message");
		
		Message msg = messageDao.findById(id);
		if (msg == null) {
			//TODO: Propper error handling
			return model;
		}
		
		msg.setHasRead(true);
		messageDao.save(msg);
		log.info("Updated message status to read for message " + msg.getId());
		
		model.addObject("msg", msg);
		return model;
		
	}
}


