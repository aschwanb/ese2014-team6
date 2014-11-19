package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Responsible to save and load AdForms to/from the data base
 * 
 * @author TeamSiX
 */
public interface MessageService {
	
	public Iterable<Message> findAll();
	public Message loadByFromUser(User user);
	public Message loadByToUser(User user);
	
	public Message saveMessage(MessageForm messageForm) throws InvalidUserException;

}
