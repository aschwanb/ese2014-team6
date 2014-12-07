package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Calendar;
import ch.studihome.jspserver.model.Event;
import ch.studihome.jspserver.model.User;

public class CalendarTest
{

	@Test
	public void testSetUserGetUser()
	{
		Calendar calendar = new Calendar();
		User expected = new User();
		expected.setusrId(1l);
		calendar.setUser(expected);
		User actual = calendar.getUser();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetNameGetName()
	{
		Calendar calendar = new Calendar();
		String expected = "Name";
		calendar.setName(expected);
		String actual = calendar.getName();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetEventsGetEvents()
	{
		Calendar calendar = new Calendar();
		Set<Event> events = new HashSet<Event>(0);
		Event event1 = new Event();
		event1.setTitle("Event1");
		Event event2 = new Event();
		event2.setTitle("Event2");
		Event event3 = new Event();
		event3.setTitle("Event3");
		events.add(event1);
		events.add(event2);
		events.add(event3);
		calendar.setEvents(events);
		Set<Event> result = calendar.getEvents();
		Iterator<Event> itr = events.iterator();
		Iterator<Event> itr2 = result.iterator();
		assertEquals(events.size(), result.size());
		while(itr.hasNext())
		{
			Event expected = itr.next();
			Event actual = itr2.next();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testAddEvent()
	{
		Calendar calendar = new Calendar();
		Set<Event> events = new HashSet<Event>(0);
		Event event1 = new Event();
		event1.setTitle("Event1");
		Event event2 = new Event();
		event2.setTitle("Event2");
		Event event3 = new Event();
		event3.setTitle("Event3");
		events.add(event1);
		events.add(event2);
		events.add(event3);
		calendar.setEvents(events);
		Event event4 = new Event();
		event4.setTitle("Event4");
		events.add(event4);
		calendar.addEvent(event4);
		Set<Event> result = calendar.getEvents();
		Iterator<Event> itr = events.iterator();
		Iterator<Event> itr2 = result.iterator();
		assertEquals(events.size(), result.size());
		while(itr.hasNext())
		{
			Event expected = itr.next();
			Event actual = itr2.next();
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testToStringGetString()
	{
		Calendar calendar = new Calendar();
		Set<Event> events = new HashSet<Event>(0);
		Event event1 = new Event();
		event1.setTitle("Event1");
		Advert advert1 = new Advert();
		advert1.setadvId(1l);
		event1.setAdvert(advert1);
		Event event2 = new Event();
		event2.setTitle("Event2");
		Advert advert2 = new Advert();
		advert2.setadvId(2l);
		event2.setAdvert(advert2);
		Event event3 = new Event();
		event3.setTitle("Event3");
		Advert advert3 = new Advert();
		advert3.setadvId(3l);
		event3.setAdvert(advert3);
		events.add(event1);
		events.add(event2);
		events.add(event3);
		calendar.setEvents(events);
		String name = "Name";
		calendar.setName(name);
		
		String expected = "<div class=\"col-sm-4\">\n" +
				 "<script>" + 
				 "$(document).ready(function() {\n"+
				 "var monthNames = [ \"January\", \"February\", \"March\", \"April\", \"May\", \"June\", "+
				 "\"July\", \"August\", \"September\", \"October\", \"November\", \"December\" ];" +
				 "var dayNames = [ \"M\", \"T\", \"W\", \"T\", \"F\", \"S\", \"S\"];" +
				 "var events = [";
	if (events != null) {
		for (Event e : events) { expected = expected + e.toString(); }
	}
	expected = expected + "];\n" +
			String.format("$(\'#%s\').bic_calendar({\n" +
				"events : events,\n"+
				"enableSelect : false,\n"+
				"multiSelect : false,\n"+
				"dayNames : dayNames,\n"+
				"monthNames : monthNames,\n"+
				"showDays : true,\n"+
				"displayMonthController : true,\n"+
				"displayYearController : true,\n"+
				"reqAjax : {\n"+
				"type : \'get\',\n"+
				"url : \'http://bic.cat/bic_calendar/index.php\'\n"+
				"}\n"+
				"});\n"+
				"});\n"+
				"</script>\n"+
				"<div id=\"%s\"></div>\n"+
				"</div>\n",
				name, name);
	String actual = calendar.getString();
	assertEquals(expected, actual);
	}

}
