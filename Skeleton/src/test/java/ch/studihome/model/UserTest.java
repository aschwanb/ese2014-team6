package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ch.studihome.jspserver.model.Advert;
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
		String user_role = "advertiser";
		String enabled = "12/12/2012";
		user.setEnabled(enabled);
		
		String expected = "FirstName: " + firstName + "\n"+
    			"LastName: " + lastName + "\n"+
    			"UserName: " + userName + "\n"+
    			"Email: " + email + "\n"+
    			"Password: " + password + "\n"+
    			"Enabled: " + enabled + "\n";
		String actual = user.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUsr_idGetUsr_id()
	{
		User user = new User();
		long id = 123;
		user.setUsr_id(id);
		long actual = user.getUsr_id();
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
		ad1.setAdv_id(1l);
		Advert ad2 = new Advert();
		ad2.setAdv_id(2l);
		Advert ad3 = new Advert();
		ad3.setAdv_id(3l);
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
	

}
