package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Event;


public class EventTest {

	@Test
	public void testToString()
	{
		String date = "2/12/2014";
		String title = "SPORT and WELLNESS";
		Advert advert = new Advert();
		advert.setadvId(1l);
		advert.setTitle("Blabla");
		String linkTarget = "_blank";
		String color = "blue";
		Event event = new Event();
		event.setDate(date);
		event.setTitle(title);
		event.setLinkTarget(linkTarget);
		event.setColor(color);
		event .setAdvert(advert);
		String expected = String.format(
				"{\n" +
				"date : \'%s\',\n" +
				"title : \'%s\',\n" +
				"link : \'%s\',\n" +
				"linkTarget : \'%s\',\n" +
				"color : \'%s\',\n" +
				"content : \'%s\',\n" +
				"class : \'\',\n" +
				"displayMonthController : \'true\',\n" +
				"displayYearController : \'true\',\n" +
				"nMonths : \'6',\n" +
				"},",
				event.getDate(), event.getTitle(), event.getLink(), event.getLinkTarget(), event.getColor(), event.getAdvert().getTitle());
		String actual = event.toString();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAdvertGetAdvert()
	{
		Event event = new Event();
		Advert expected = new Advert();
		expected.setadvId(1l);
		event.setAdvert(expected);
		Advert actual = event.getAdvert();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetDateGetDate()
	{
		Event event = new Event();
		String expected = "2/12/2014";
		event.setDate(expected);
		String actual = event.getDate();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetTitleGetTitle()
	{
		Event event = new Event();
		String expected = "Title";
		event.setTitle(expected);
		String actual = event.getTitle();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetLink()
	{
		Event event = new Event();
		Advert advert = new Advert();
		advert.setadvId(1l);
		event.setAdvert(advert);
		String actual = event.getLink();
		assertEquals("advert?id="+advert.getadvId().toString(), actual);
	}

	@Test
	public void testSetLinkTargetGetLinkTarget()
	{
		Event event = new Event();
		String expected = "_blank";
		event.setLinkTarget(expected);
		String actual = event.getLinkTarget();
		assertEquals(expected, actual);
	}


	@Test
	public void testSetColorGetColor()
	{
		Event event = new Event();
		String expected = "red";
		event.setColor(expected);
		String actual = event.getColor();
		assertEquals(expected, actual);
	}
}
