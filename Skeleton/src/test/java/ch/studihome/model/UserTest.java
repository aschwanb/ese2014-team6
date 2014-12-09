package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.Calendar;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;

public class UserTest
{

	@Test
	public void testToString()
	{
		User user = new User();
		String firstName = "Hans";
		user.setFirstName(firstName);
		String lastName = "Meier";
		user.setLastName(lastName);
		String userName = "Haner12";
		user.setUserName(userName);
		String email = "h.meier@test.com";
		user.setEmail(email);
		String password = "NotMyBirthDate";
		user.setPassword(password);
		String user_role = "ROLE_USER";
		user.setUser_role(user_role);
		String enabled = "12/12/2012";
		user.setEnabled(enabled);
		
		String expected = "FirstName: " + firstName + "\n"+
    			"LastName: " + lastName + "\n"+
    			"UserName: " + userName + "\n"+
    			"Email: " + email + "\n"+
    			"Password: " + password + "\n"+
    			"UserRole: " + user_role + "\n"+
    			"Enabled: " + enabled + "\n"+
    	    	"GrantedAuthority: " + user_role;
		String actual = user.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetusrIdGetusrId()
	{
		User user = new User();
		long id = 123;
		user.setusrId(id);
		long actual = user.getusrId();
		assertEquals(id, actual);
	}

	@Test
	public void testSetFistNameGetFirstName()
	{
		User user = new User();
		String firstName = "Hans";
		user.setFirstName(firstName);
		String actual = user.getFirstName();
		assertEquals(firstName, actual);
	}

	@Test
	public void testSetLastNameGetLastName()
	{
		User user = new User();
		String lastName = "Meier";
		user.setLastName(lastName);
		String actual = user.getLastName();
		assertEquals(lastName, actual);
	}

	@Test
	public void testSetEmailGetEmail()
	{
		User user = new User();
		String email = "h.meier@test.com";
		user.setEmail(email);
		String actual = user.getEmail();
		assertEquals(email, actual);
	}

	@Test
	public void testSetPasswordGetPassword()
	{
		User user = new User();
		String password = "NotMyBirthDate";
		user.setPassword(password);
		String actual = user.getPassword();
		assertEquals(password, actual);
	}

	@Test
	public void testSetUserNameGetUserName()
	{
		User user = new User();
		String userName = "Haner12";
		user.setUserName(userName);
		String actual = user.getUserName();
		assertEquals(userName, actual);
	}

	@Test
	public void testSetUser_roleGetUser_role()
	{
		User user = new User();
		String user_role = "ROLE_USER"; 
		user.setUser_role(user_role);
		String actual = user.getUser_role();
		assertEquals(user_role, actual);
	}

	@Test
	public void testSetEnabledGetEnabled()
	{
		User user = new User();
		String enabled = "TRUE"; 
		user.setEnabled(enabled);
		String actual = user.getEnabled();
		assertEquals(enabled, actual);
	}
	
	@Test
	public void testSetAdsGetAds()
	{
		User user = new User();
		Set<Advert> ads = new HashSet<Advert>(0);
		Advert ad1 = new Advert();
		ad1.setadvId(1l);
		Advert ad2 = new Advert();
		ad2.setadvId(2l);
		Advert ad3 = new Advert();
		ad3.setadvId(3l);
		ads.add(ad1);
		ads.add(ad2);
		ads.add(ad3);
		user.setAds(ads);
		Iterator<Advert> itr = ads.iterator();
		Set<Advert> result = user.getAds();
		Iterator<Advert> itr2 = result.iterator();
		assertEquals(ads.size(), result.size());
		while(itr.hasNext())
		{
			Advert expected = itr.next();
			Advert actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSetFromMsgsGetFromMsgs()
	{
		User user = new User();
		Set<Message> fromMsgs = new HashSet<Message>();
		Message msg1 = new Message();
		msg1.setId(1l);
		Message msg2 = new Message();
		msg2.setId(2l);
		Message msg3 = new Message();
		msg3.setId(3l);
		fromMsgs.add(msg1);
		fromMsgs.add(msg2);
		fromMsgs.add(msg3);
		user.setFromMsgs(fromMsgs);
		Iterator<Message> itr = fromMsgs.iterator();
		Set<Message> result = user.getFromMsgs();
		Iterator<Message> itr2 = result.iterator();
		assertEquals(fromMsgs.size(), result.size());
		while(itr.hasNext())
		{
			Message expected = itr.next();
			Message actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSetToMsgsGetToMsgs()
	{
		User user = new User();
		Set<Message> toMsgs = new HashSet<Message>();
		Message msg1 = new Message();
		msg1.setId(1l);
		Message msg2 = new Message();
		msg2.setId(2l);
		Message msg3 = new Message();
		msg3.setId(3l);
		toMsgs.add(msg1);
		toMsgs.add(msg2);
		toMsgs.add(msg3);
		user.setFromMsgs(toMsgs);
		Iterator<Message> itr = toMsgs.iterator();
		Set<Message> result = user.getFromMsgs();
		Iterator<Message> itr2 = result.iterator();
		assertEquals(toMsgs.size(), result.size());
		while(itr.hasNext())
		{
			Message expected = itr.next();
			Message actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSetCalendarGetCalendar()
	{
		User user = new User();
		Calendar expected = new Calendar();
		expected.setName("Testcalendar");
		user.setCalendar(expected);
		Calendar actual = user.getCalendar();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetAlertsGetAlerts()
	{
		User user = new User();
		Set<Alert> alerts = new HashSet<Alert>();
		Alert alert1 = new Alert();
		alert1.setAlertId(1l);
		Alert alert2 = new Alert();
		alert2.setAlertId(2l);
		Alert alert3 = new Alert();
		alert3.setAlertId(3l);
		alerts.add(alert1);
		alerts.add(alert2);
		alerts.add(alert3);
		user.setAlerts(alerts);
		Iterator<Alert> itr = alerts.iterator();
		Set<Alert> result = user.getAlerts();
		Iterator<Alert> itr2 = result.iterator();
		assertEquals(alerts.size(), result.size());
		while(itr.hasNext())
		{
			Alert expected = itr.next();
			Alert actual = itr2.next();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSetBookmarksGetBookmarks()
	{
		User user = new User();
		Set<Bookmark> bookmarks = new HashSet<Bookmark>(0);
		Bookmark bm1 = new Bookmark();
		bm1.setBmId(1l);
		Bookmark bm2 = new Bookmark();
		bm2.setBmId(2l);
		Bookmark bm3 = new Bookmark();
		bm3.setBmId(3l);
		bookmarks.add(bm1);
		bookmarks.add(bm2);
		bookmarks.add(bm3);
		user.setBookmarks(bookmarks);
		Iterator<Bookmark> itr = bookmarks.iterator();
		Set<Bookmark> result = user.getBookmarks();
		Iterator<Bookmark> itr2 = result.iterator();
		assertEquals(bookmarks.size(), result.size());
		while(itr.hasNext())
		{
			Bookmark expected = itr.next();
			Bookmark actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	
}
