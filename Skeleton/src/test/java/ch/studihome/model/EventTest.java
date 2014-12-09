package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Event;
import ch.studihome.jspserver.model.RoomImg;


public class EventTest {

	@Test
	public void testToString()
	{
		String date = "2/12/2014";
		Advert advert = new Advert();
		advert.setadvId(1l);
		advert.setTitle("Blabla");
		HashSet<RoomImg> imgs = new HashSet<RoomImg>();
		RoomImg img = new RoomImg();
		img.setImgName("image");
		imgs.add(img);
		advert.setImgs(imgs);
		String linkTarget = "_blank";
		String color = "blue";
		Event event = new Event();
		event.setDate(date);
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
				event.getDate(), event.getAdvert().getTitle(), event.getLink(), event.getLinkTarget(), event.getColor(),
				"<img src=\"usrimg/" + event.getAdvert().getFirstImage() + "\" height=\"200\" width=\"200\">");
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
