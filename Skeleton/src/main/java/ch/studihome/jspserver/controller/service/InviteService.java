package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.InvitationForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Responsible to save and load AdForms to/from the data base
 * 
 * @author TeamSiX
 */
public interface InviteService {
	
//	Load
	public Iterable<Invite> findAll();
//	public Iterable<Invite> findByFromUser(User user);
//	public Iterable<Invite> findByToUser(User user);
//	Save
	public InvitationForm saveInvite(InvitationForm invitationForm) throws InvalidUserException;

}
