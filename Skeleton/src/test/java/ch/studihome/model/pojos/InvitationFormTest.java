package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.pojos.InvitationForm;

public class InvitationFormTest
{

	@Test
	public void testToString()
	{
		long id = 1l;
		String toUserEmail = "test@test.com";
		String fromUserEmail = "test@test.com";
		String title = "title";
		String message = "message";
		String invTime = "20:15";
		String invDate = "24/10/14";
		InvitationForm invitationForm = new InvitationForm();
		invitationForm.setId(id);
		invitationForm.setToUserEmail(toUserEmail);
		invitationForm.setFromUserEmail(fromUserEmail);
		invitationForm.setTitle(title);
		invitationForm.setMessage(message);
		invitationForm.setInvTime(invTime);
		invitationForm.setInvDate(invDate);
		String expected = "ID: " + id + "\n" +
				 "To User: " + toUserEmail + "\n" +
				 "From User: " + fromUserEmail + "\n" +
				 "Title: " + title + "\n" +
				 "Message: " + message + "\n" +
					"Time: " + invTime + "\n" +
					"Date: " + invDate;
		String actual = invitationForm.toString();
	}

	@Test
	public void testSetUsrIdGetUsrId()
	{
		InvitationForm invitationForm = new InvitationForm();
		long expected = 1l;
		invitationForm.setUsrId(expected);
		long actual = invitationForm.getUsrId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAdIdGetAdId()
	{
		InvitationForm invitationForm = new InvitationForm();
		long expected = 1l;
		invitationForm.setAdId(expected);
		long actual = invitationForm.getAdId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetInvTimeGetInvTime()
	{
		InvitationForm invitationForm = new InvitationForm();
		String expected = "20:15";
		invitationForm.setInvTime(expected);
		String actual = invitationForm.getInvTime();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetInvDateGetInvDate()
	{
		InvitationForm invitationForm = new InvitationForm();
		String expected = "12/21/12";
		invitationForm.setInvDate(expected);
		String actual = invitationForm.getInvDate();
		assertEquals(expected, actual);
	}

}
