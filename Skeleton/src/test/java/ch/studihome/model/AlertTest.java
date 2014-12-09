package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;

public class AlertTest
{

	@Test
	public void testSetAlertIdGetAlertId()
	{
		Alert alert = new Alert();
		long expected = 1l;
		alert.setAlertId(expected);
		long actual = alert.getAlertId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetUserGetUser()
	{
		Alert alert = new Alert();
		User expected = new User();
		expected.setusrId(1l);
		alert.setUser(expected);
		User actual = alert.getUser();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinpriceGetMinprice()
	{
		Alert alert = new Alert();
		int expected = 100;
		alert.setMinprice(expected);
		int actual = alert.getMinprice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxpriceGetMaxprice()
	{
		Alert alert = new Alert();
		int expected = 1000;
		alert.setMaxprice(expected);
		int actual = alert.getMaxprice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinroomsizeGetMinroomsize()
	{
		Alert alert = new Alert();
		int expected = 20;
		alert.setMinroomsize(expected);
		int actual = alert.getMinroomsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxroomsizeGetMaxroomsize()
	{
		Alert alert = new Alert();
		int expected = 25;
		alert.setMaxroomsize(expected);
		int actual = alert.getMaxroomsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinappartmentsizeGetMinappartmentsize()
	{
		Alert alert = new Alert();
		int expected = 200;
		alert.setMinappartmentsize(expected);
		int actual = alert.getMinappartmentsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxappartmentsizeGetMaxappartmentsize()
	{
		Alert alert = new Alert();
		int expected = 250;
		alert.setMaxappartmentsize(expected);
		int actual = alert.getMaxappartmentsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetminnumberofinhabitantsGetMinnumberofinhabitants()
	{
		Alert alert = new Alert();
		int expected = 2;
		alert.setMinnumberofinhabitants(expected);
		int actual = alert.getMinnumberofinhabitants();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxnumberofinhabitantsGetMaxnumberofinhabitants()
	{
		Alert alert = new Alert();
		int expected = 5;
		alert.setMaxnumberofinhabitants(expected);
		int actual = alert.getMaxnumberofinhabitants();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAreaGetArea()
	{
		Alert alert = new Alert();
		String expected = "Bern";
		alert.setArea(expected);
		String actual = alert.getArea();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetTypeofappartmentGetTypeofappartment()
	{
		Alert alert = new Alert();
		String expected = "Shared Flat";
		alert.setTypeofappartment(expected);
		String actual = alert.getTypeofappartment();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetTimeAndDate()
	{
		Alert alert = new Alert();
		long expected = new Date().getTime();
		alert.setTimeAndDate(expected);
		long actual = alert.getTimeAndDate();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAdvertsGetAdverts()
	{
		Alert alert = new Alert();
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
		alert.setAdverts(ads);
		Iterator<Advert> itr = ads.iterator();
		Set<Advert> result = alert.getAdverts();
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
