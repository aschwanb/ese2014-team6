package ch.studihome.jspserver.controller.service;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.studihome.jspserver.controller.exceptions.ImageSaveException;
import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.InvitationForm;
import ch.studihome.jspserver.model.pojos.MessageForm;

/**
 * Implementation of Invite Service using daos.
 * 
 * @author TeamSix
 *
 */
@Service
public class InviteServiceImpl implements InviteService {
	
	@Autowired InviteDao inviteDao;
	@Autowired UserDao userDao;
	@Autowired AdvertDao advertDao;
	
	static Logger log = Logger.getLogger(InviteServiceImpl.class.getName());
	
	public InviteServiceImpl(){}
	public InviteServiceImpl(InviteDao inviteDao, UserDao userDao, AdvertDao advertDao)
	{
		this.inviteDao = inviteDao;
		this.userDao = userDao;
		this.advertDao = advertDao;
	}
	
	public Iterable<Invite> findAll() {
		return inviteDao.findAll();
	}
	
	public InvitationForm saveInvite(InvitationForm invitationForm) throws InvalidUserException {
//		Check if both Users exist
//		Todo: Why is userDao.findByEmail returning a list of users?
		User toUser = userDao.findByUserName(invitationForm.getToUserEmail());		
		User fromUser = userDao.findByUserName(invitationForm.getFromUserEmail());
		if (toUser == null || fromUser == null) {
			log.info("One or more users do not exist.");
			throw new InvalidUserException("One or more users do not exist.");
		}
//		Create and save form
		try {
			Invite  invite = new Invite(fromUser, toUser, invitationForm.getTitle(),
					invitationForm.getMessage(), invitationForm.getInvDate(), 
					invitationForm.getInvTime(), advertDao.findByAdvId(invitationForm.getAdId()));
			inviteDao.save(invite);		
			// TODO: Update existing user object with the new information.
		} catch (Exception e) {
			e.printStackTrace();
		}
		return invitationForm;	
	}
}
