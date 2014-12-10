package ch.studihome.controller.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import ch.studihome.jspserver.controller.service.AdServiceImpl;
import ch.studihome.jspserver.controller.service.MessageServiceImpl;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.RoomImgDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.MessageForm;

public class MessageServiceImplTest
{

	MessageDao messageDao;
	UserDao userDao;
	MessageServiceImpl messageServiceImpl;
	
	@Before
	public void doSetup()
	{
		messageDao = mock(MessageDao.class);
		userDao = mock(UserDao.class);
		messageServiceImpl = new MessageServiceImpl(messageDao, userDao);
	}
	
	@Test
	public void testFindAll()
	{
		assertTrue(true);
	}

	@Test
	public void testFindByFromUser()
	{
		User user = new User();
		HashSet<Message> msgs = new HashSet<Message>();
		Message message = new Message();
		message.setId(1l);
		msgs.add(message);
		user.setFromMsgs(msgs);
		HashSet<Message> results = (HashSet<Message>) messageServiceImpl.findByFromUser(user);
		Iterator<Message> itr = msgs.iterator();
		Iterator<Message> itr2 = results.iterator();
		assertEquals(msgs.size(), results.size());
		while(itr.hasNext())
		{
			Message expected = itr.next();
			Message actual = itr2.next();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testFindByToUser()
	{
		User user = new User();
		HashSet<Message> msgs = new HashSet<Message>();
		Message message = new Message();
		message.setId(1l);
		msgs.add(message);
		user.setToMsgs(msgs);
		HashSet<Message> results = (HashSet<Message>) messageServiceImpl.findByToUser(user);
		Iterator<Message> itr = msgs.iterator();
		Iterator<Message> itr2 = results.iterator();
		assertEquals(msgs.size(), results.size());
		while(itr.hasNext())
		{
			Message expected = itr.next();
			Message actual = itr2.next();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSaveMessage()
	{
		when(userDao.findByUserName(any(String.class))).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				return user;
			}
		});
		MessageForm messageForm = new MessageForm();
		messageForm.setFromUserEmail("blabla");
		messageForm.setToUserEmail("blabla");
		messageForm.setTitle("title");
		messageForm.setMessage("message");
		when(messageDao.save(any(Message.class))).thenAnswer(new Answer<Boolean>() {

			public Boolean answer(InvocationOnMock invocation)
					throws Throwable
			{
				Message message = (Message) invocation.getArguments()[0];
				assertEquals("title", message.getTitle());
				assertEquals("message", message.getMessage());
				return true;
			}
		});
	}

}
