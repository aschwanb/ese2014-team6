package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.pojos.MessageForm;

public class MessageFormTest
{

	@Test
	public void testToString()
	{
		long id = 1l;
		String toUserEmail = "test@test.com";
		String fromUserEmail = "test@test.com";
		String title = "title";
		String message = "message";
		MessageForm messageForm = new MessageForm();
		messageForm.setId(id);
		messageForm.setToUserEmail(toUserEmail);
		messageForm.setFromUserEmail(fromUserEmail);
		messageForm.setTitle(title);
		messageForm.setMessage(message);
		String expected = "ID: " + id + "\n" +
				 "To User: " + toUserEmail + "\n" +
				 "From User: " + fromUserEmail + "\n" +
				 "Title: " + title + "\n" +
				 "Message: " + message;
		String actual = messageForm.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetIdGetId()
	{
		MessageForm messageForm = new MessageForm();
		long expected = 1l;
		messageForm.setId(expected);
		long actual = messageForm.getId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetFromUserEmailGetFromUserEmail()
	{
		MessageForm messageForm = new MessageForm();
		String expected = "test@test.com";
		messageForm.setFromUserEmail(expected);
		String actual = messageForm.getFromUserEmail();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetToUserEmailGetToUserEmail()
	{
		MessageForm messageForm = new MessageForm();
		String expected = "test@test.com";
		messageForm.setToUserEmail(expected);
		String actual = messageForm.getToUserEmail();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTitle()
	{
		MessageForm messageForm = new MessageForm();
		String expected = "title";
		messageForm.setTitle(expected);
		String actual = messageForm.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetMessage()
	{
		MessageForm messageForm = new MessageForm();
		String expected = "message";
		messageForm.setMessage(expected);
		String actual = messageForm.getMessage();
		assertEquals(expected, actual);
	}

}
