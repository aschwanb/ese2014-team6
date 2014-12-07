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
		String link = "http://bic.cat";
		String linkTarget = "_blank";
		String color = "blue";
		String content = "BlaBla";
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
				date, title, link, linkTarget, color, content);
		Event event = new Event();
		event.setDate(date);
		event.setTitle(title);
		event.setLink(link);
		event.setLinkTarget(linkTarget);
		event.setColor(color);
		event.setContent(content);
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
	public void testSetLinkGetLink()
	{
		Event event = new Event();
		String expected = "http://bic.cat";
		event.setLink(expected);
		String actual = event.getLink();
		assertEquals(expected, actual);
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

	@Test
	public void testSetContentGetContent()
	{
		Event event = new Event();
		String expected = "Content";
		event.setContent(expected);
		String actual = event.getContent();
		assertEquals(expected, actual);
	}
}
