package ch.studihome.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.any;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.BookmarkController;
import ch.studihome.jspserver.controller.InviteController;
import ch.studihome.jspserver.controller.service.InviteService;
import ch.studihome.jspserver.controller.service.InviteServiceImpl;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.BookmarkDao;
import ch.studihome.jspserver.model.dao.CalendarDao;
import ch.studihome.jspserver.model.dao.EventDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.InvitationForm;

public class InviteControllerTest
{
	InviteDao inviteDao;
	InviteService inviteService;
	AdvertDao advertDao;
	UserDao userDao;
	MessageDao messageDao;
	CalendarDao calendarDao;
	EventDao eventDao;
	InviteController inviteController;
	
	
	@Before
	public void doSetup()
	{
		inviteDao = mock(InviteDao.class);
		inviteService = mock(InviteServiceImpl.class);
		userDao = mock(UserDao.class);
		advertDao = mock(AdvertDao.class);
		messageDao = mock(MessageDao.class);
		calendarDao = mock(CalendarDao.class);
		eventDao = mock(EventDao.class);
		User user = new User();
		user.setUserName("hans");
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		inviteController = new InviteController(inviteDao, inviteService, 
				advertDao, userDao, messageDao, calendarDao, eventDao);
	}
	
	@Test
	public void testInviteReact()
	{
		when(messageDao.findById(any(Long.class))).thenAnswer(new Answer<Message>() {

			public Message answer(InvocationOnMock invocation)
					throws Throwable
			{
				Message message = new Message();
				message.setMessage("message");
				User fromUser = new User();
				message.setFromUser(fromUser);
				return message;
			}
		});
		
		when(inviteDao.findById(any(Long.class))).thenAnswer(new Answer<Invite>() {

			public Invite answer(InvocationOnMock invocation)
					throws Throwable
			{
				Invite invite = new Invite();
				invite.setReacted(true);
				return invite;
			}
		});
		
		ModelAndView model = inviteController.inviteReact(0l, false);
		String message = ((Message) model.getModel().get("msg")).getMessage();
		assertEquals("message", message);
		
		BSalert[] bSalerts = (BSalert[]) model.getModel().get("alerts");
		BSalert bSalert = bSalerts[0];
		String alert = bSalert.getMessage();
		assertEquals("<strong>Error!</strong> You allready reacted to this invitation.", alert);
		
		User fromUserexp = new User();
		fromUserexp.setUserName("hans");
		User fromUseract = (User) model.getModel().get("fromUser");
		assertEquals(fromUserexp, fromUseract);
		
		User toUserexp = new User();
		User toUseract = (User) model.getModel().get("toUser");
		assertEquals(toUserexp, toUseract);
	}

	@Test
	public void testInvite()
	{
		when(userDao.findByUsrId(any(Long.class))).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				return user;
			}
		});
		
		ModelAndView model = inviteController.invite(0l, 0l);
		
		User fromUserexp = new User();
		fromUserexp.setUserName("hans");
		User fromUseract = (User) model.getModel().get("fromUser");
		assertEquals(fromUserexp, fromUseract);
		
		User toUserexp = new User();
		toUserexp.setusrId(1l);
		User toUseract = (User) model.getModel().get("toUser");
		assertEquals(toUserexp, toUseract);

		long userIdexp = 0l;
		long userIdact = (Long) model.getModel().get("usrId");
		assertEquals(userIdexp, userIdact);
		
		long adIdexp = 0l;
		long adIdact = (Long) model.getModel().get("adId");
		assertEquals(adIdexp, adIdact);
	}


}
