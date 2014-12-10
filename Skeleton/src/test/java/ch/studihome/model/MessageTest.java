package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;

public class MessageTest
{

	@Test
	public void testToString()
	{
		long id = 1l;
		User fromUser = new User();
		fromUser.setEmail("test@test.com");
		User toUser = new User();
		boolean hasRead = true;
		boolean hasResponded = true;
		String title = "Hi";
		String msg = "How are you?";
		Message message = new Message();
		message.setId(id);
		message.setFromUser(fromUser);
		message.setToUser(toUser);
		message.setHasRead(hasRead);
		message.setHasResponded(hasResponded);
		message.setTitle(title);
		message.setMessage(msg);
		String expected = "ID: " + id + "\n" +
				 "From User: " + fromUser.getEmail() + "\n" +
				 "To User: " + toUser.getEmail() + "\n" +
				 "Message is unread: " + message.getHasRead().toString() + "\n" +
				 "From User: " + message.getHasResponded().toString() + "\n" +
				 "Title: " + title + "\n" +
				 "Message: " + msg;
		String actual = message.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFromUserGetFromUser()
	{
		Message message = new Message();
		User expected = new User();
		expected.setusrId(1l);
		message.setFromUser(expected);
		User actual = message.getFromUser();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetToUserGetToUser()
	{
		Message message = new Message();
		User expected = new User();
		expected.setusrId(1l);
		message.setToUser(expected);
		User actual = message.getToUser();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetTitleGetTitle()
	{
		Message message = new Message();
		String expected = "title";
		message.setTitle(expected);
		String actual = message.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetIdGetId()
	{
		Message message = new Message();
		long expected = 1l;
		message.setId(expected);
		long actual = message.getId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDateGetDate()
	{
		Message message = new Message();
		Date expected = new Date();
		message.setDate(expected);
		Date actual = message.getDate();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMessageGetMessage()
	{
		Message message = new Message();
		String expected = "message";
		message.setMessage(expected);
		String actual = message.getMessage();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetHasReadGetHasRead()
	{
		Message message = new Message();
		boolean expected = true;
		message.setHasRead(expected);
		boolean actual = message.getHasRead();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetHasRespondedGetHasResponded()
	{
		Message message = new Message();
		boolean expected = true;
		message.setHasResponded(expected);
		boolean actual = message.getHasResponded();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetInvite()
	{
		Message message = new Message();
		assertEquals(false, message.getInvite());
	}

}
