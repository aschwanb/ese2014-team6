package ch.studihome.jspserver.controller.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

@Service
public class MessageServiceImpl implements MessageService {
	
	@Autowired MessageDao messageDao;
	@Autowired UserDao userDao;
	
	static Logger log = Logger.getLogger(MessageServiceImpl.class.getName());
	
	public Iterable<Message> findAll() {
		return messageDao.findAll();
	}
	public Iterable<Message> findByFromUser(User user) {
		return user.getFromMsgs();
	}
	public Iterable<Message> findByToUser(User user) {
		return user.getToMsgs();
	}
	
	public MessageForm saveMessage(MessageForm messageForm) throws InvalidUserException {
//		Check if both Users exist
//		Todo: Why is userDao.findByEmail returning a list of users?
		User toUser = userDao.findByUserName(messageForm.getToUserEmail());		
		User fromUser = userDao.findByUserName(messageForm.getFromUserEmail());
		if (toUser == null || fromUser == null) {
			log.info("One or more users do not exist.");
			throw new InvalidUserException("One or more users do not exist.");
		}
//		Create and save form
		try {
			Message message = new Message(fromUser, toUser, messageForm.getTitle(), messageForm.getMessage());
			messageDao.save(message);		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return messageForm;	
	}

}
