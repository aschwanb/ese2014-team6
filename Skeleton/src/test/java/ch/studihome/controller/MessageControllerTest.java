package ch.studihome.controller;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.InviteController;
import ch.studihome.jspserver.controller.MessageController;
import ch.studihome.jspserver.controller.service.InviteService;
import ch.studihome.jspserver.controller.service.InviteServiceImpl;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.MessageServiceImpl;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.controller.service.UserService;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.CalendarDao;
import ch.studihome.jspserver.model.dao.EventDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;

public class MessageControllerTest
{
	AdvertDao advertDao;
	UserDao userDao;
	MessageDao messageDao;
	MessageService messageService;
	MyUserDetailsService userService;
	MessageController messageController;
	
	
	@Before
	public void doSetup()
	{
		userDao = mock(UserDao.class);
		advertDao = mock(AdvertDao.class);
		messageDao = mock(MessageDao.class);
		messageService = mock(MessageServiceImpl.class);
		userService = mock(MyUserDetailsService.class);
		User user = new User();
		user.setUserName("hans");
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null);
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		messageController = new MessageController(messageDao, 
				messageService, advertDao, userDao, userService);
	}
	
	@Test
	public void testIndex()
	{
		when(userService.getUser()).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				HashSet<Message> msgs = new HashSet<Message>();
				Message msg = new Message();
				msgs.add(msg);
				user.setToMsgs(msgs);
				return user;
			}
		});
		
		ModelAndView model = messageController.index();
		
		User userexp = new User();
		userexp.setusrId(1l);
		HashSet<Message> msgs = new HashSet<Message>();
		Message msg = new Message();
		msgs.add(msg);
		userexp.setToMsgs(msgs);
		User useract = (User) model.getModel().get("user");
		assertEquals(userexp, useract);
		
		Message msgexp = new Message();
		Message msgact = ((ArrayList<Message>) model.getModel().get("msgs")).get(0);
		assertEquals(msgexp, msgact);
		
	}

	@Test
	public void testMessageToAdvertiser()
	{
		when(userDao.findByUsrId(any(long.class))).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				return user;
			}
		});
		
		ModelAndView model = messageController.messageToAdvertiser(null, 1l, null);
		User fromUserexp = new User();
		fromUserexp.setUserName("hans");
		User fromUseract = (User) model.getModel().get("fromUser");
		assertEquals(fromUserexp, fromUseract);
		
		User toUserexp = new User();
		toUserexp.setusrId(1l);
		User toUseract = (User) model.getModel().get("toUser");
		assertEquals(toUserexp, toUseract);
	}

	
	@Test
	public void testMessageShow()
	{
		when(messageDao.findById(any(long.class))).thenAnswer(new Answer<Message>() {

			public Message answer(InvocationOnMock invocation)
					throws Throwable
			{
				return null;
			}
		});
		
		ModelAndView model = messageController.messageShow(1l);
		String expected = "message";
		String actual = model.getViewName();
		assertEquals(expected, actual);
	}

}
