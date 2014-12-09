package ch.studihome.controller.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Matchers.any;

import org.mockito.stubbing.Answer;

import ch.studihome.jspserver.controller.service.InviteServiceImpl;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Invite;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.InvitationForm;

public class InviteServiceImplTest
{
	private AdvertDao advertDao;
	private UserDao userDao;
	private InviteDao inviteDao;
	private InviteServiceImpl inviteServiceImpl;
	
	@Before
	public void doSetup()
	{
		advertDao = mock(AdvertDao.class);
		userDao = mock(UserDao.class);
		inviteDao = mock(InviteDao.class);
		inviteServiceImpl = new InviteServiceImpl(inviteDao, userDao, advertDao);
	}
	@Test
	public void testFindAll()
	{
		assertTrue(true);
	}

	@Test
	public void testSaveInvite()
	{
		when(advertDao.findByAdvId(any(long.class))).thenAnswer(new Answer<Advert>() {

			public Advert answer(InvocationOnMock invocation)
					throws Throwable
			{
				return new Advert();
			}
		});
		
		when(userDao.findByUserName(any(String.class))).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				return user;
			}
		});
		
		
		String email = "blabla";
		String title = "title";
		String message = "message";
		String invDate = "23/12/13";
		String invTime = "22:15";
		InvitationForm invitationForm = new InvitationForm();
		invitationForm.setFromUserEmail(email);
		invitationForm.setToUserEmail(email);
		invitationForm.setTitle(title);
		invitationForm.setMessage(message);
		invitationForm.setInvDate(invDate);
		invitationForm.setInvTime(invTime);
		inviteServiceImpl.saveInvite(invitationForm);
		
		when(inviteDao.save(any(Invite.class))).thenAnswer(new Answer<Boolean>() {

			public Boolean answer(InvocationOnMock invocation)
					throws Throwable
			{
				Invite invite = (Invite) invocation.getArguments()[0];
				assertEquals("title", invite.getTitle());
				assertEquals("message", invite.getMessage());
				assertEquals("23/12/13", invite.getInvDate());
				assertEquals("22:15", invite.getInvTime());
				return true;
			}
		});
	}

}
