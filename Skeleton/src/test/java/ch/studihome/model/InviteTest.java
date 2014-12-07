package ch.studihome.model;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Invite;

public class InviteTest {

	@Test
	public void testGetInvite()
	{
		Invite invite = new Invite();
		assertEquals(true, invite.getInvite());
	}

	@Test
	public void testGetLink()
	{
		Invite invite = new Invite();
		Advert advert = new Advert();
		advert.setadvId(1l);
		invite.setAdvert(advert);
		String expected = "advert?id="+advert.getadvId().toString();
		String actual = invite.getLink();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetAdvert()
	{
		Invite invite = new Invite();
		Advert expected = new Advert();
		expected.setadvId(1l);
		invite.setAdvert(expected);
		Advert actual = invite.getAdvert();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetInvDateGetInvDate()
	{
		Invite invite = new Invite();
		String expected = "24/11/14";
		invite.setInvDate(expected);
		String actual = invite.getInvDate();
		assertEquals(expected, actual);
	}
	@Test
	public void testSetInvTimeGetInvTime()
	{
		Invite invite = new Invite();
		String expected = "20:15";
		invite.setInvTime(expected);
		String actual = invite.getInvTime();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetReactedGetReacted()
	{
		Invite invite = new Invite();
		boolean expected = true;
		invite.setReacted(expected);
		boolean actual = invite.getReacted();
		assertEquals(expected, actual);
	}
}
