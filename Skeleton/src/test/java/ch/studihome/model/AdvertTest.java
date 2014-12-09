package ch.studihome.model;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.Event;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;

public class AdvertTest
{

	@Test
	public void testSetadvIdGetadvId()
	{
		Advert advert = new Advert();
		long id = 122;
		advert.setadvId(id);
		long actual = advert.getadvId();
		assertEquals(id, actual);
	}

	@Test
	public void testSetTitleGetTitle()
	{
		Advert advert = new Advert();
		String title = "zuHause";
		advert.setTitle(title);
		String actual = advert.getTitle();
		assertEquals(title, actual);
	}

	@Test
	public void testSetPriceGetPrice()
	{
		Advert advert = new Advert();
		int price = 122;
		advert.setPrice(price);
		int actual = advert.getPrice();
		assertEquals(price, actual);
	}

	@Test
	public void testSetDescriptionGetDescription()
	{
		Advert advert = new Advert();
		String description = "A nice description";
		advert.setDescription(description);
		String actual = advert.getDescription();
		assertEquals(description, actual);
	}
	
	@Test
	public void testSetAddressGetAddress()
	{
		Advert advert = new Advert();
		Address address = new Address();
		advert.setAddress(address);
		Address actual = advert.getAddress();
		assertEquals(address, actual);
	}

	@Test
	public void testSetImgsGetImgs()
	{
		Advert advert = new Advert();
		Set<RoomImg> imgs = new HashSet<RoomImg>(0);
		imgs.add(new RoomImg());
		imgs.add(new RoomImg());
		imgs.add(new RoomImg());
		advert.setImgs(imgs);
		Set<RoomImg> result = advert.getImgs();
		Iterator<RoomImg> itr = imgs.iterator();
		Iterator<RoomImg> itr2 = result.iterator();
		assertEquals(imgs.size(), result.size());
		while(itr.hasNext())
		{
			RoomImg expected = itr.next();
			RoomImg actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSetUserGetUser()
	{
		Advert advert = new Advert();
		User user = new User();
		advert.setUser(user);
		User actual = advert.getUser();
		assertEquals(user, actual);
	}

	@Test
	public void testSetIsWGGetIsWG()
	{
		Advert advert = new Advert();
		boolean isWG = true;
		advert.setIsWG(isWG);
		boolean actual = advert.getIsWG();
		assertEquals(isWG, actual);
	}

	@Test
	public void testSetAppartementSizeGetAppartementSize()
	{
		Advert advert = new Advert();
		int appartementSize = 300;
		advert.setAppartementSize(appartementSize);
		int actual = advert.getAppartementSize();
		assertEquals(appartementSize, actual);
	}

	@Test
	public void testSetNumberOfRoomsGetNumberOfRooms()
	{
		Advert advert = new Advert();
		int numberOfRooms = 4;
		advert.setNumberOfRooms(numberOfRooms);
		int actual = advert.getNumberOfRooms();
		assertEquals(numberOfRooms, actual);
	}

	@Test
	public void testSetRoomSizeGetRoomSize()
	{
		Advert advert = new Advert();
		int roomSize = 300;
		advert.setRoomSize(roomSize);
		int actual = advert.getRoomSize();
		assertEquals(roomSize, actual);
	}

	@Test
	public void testSetNumberOfInhabitantsGetNumberOfInhabitants()
	{
		Advert advert = new Advert();
		int numberOfInhabitants = 3;
		advert.setNumberOfInhabitants(numberOfInhabitants);
		int actual = advert.getNumberOfInhabitants();
		assertEquals(numberOfInhabitants, actual);
	}

	@Test
	public void testGetFirstImage()
	{
		Advert advert = new Advert();
		Set<RoomImg> imgs = new HashSet<RoomImg>(0);
		RoomImg img = new RoomImg();
		String expected = "TestImage";
		img.setImgName(expected);
		imgs.add(img);
		advert.setImgs(imgs);
		String actual = advert.getFirstImage();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetEventsGetEvents()
	{
		Advert advert = new Advert();
		Set<Event> events = new HashSet<Event>(0);
		Event event1 = new Event();
		event1.setLinkTarget("Link1");
		Event event2 = new Event();
		event2.setLinkTarget("Link2");
		Event event3 = new Event();
		event3.setLinkTarget("Link3");
		events.add(event1);
		events.add(event2);
		events.add(event3);
		advert.setEvents(events);
		Set<Event> result = advert.getEvents();
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
	public void testSetBookmarksGetBookmarks()
	{
		Advert advert = new Advert();
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
		advert.setBookmarks(bookmarks);
		Iterator<Bookmark> itr = bookmarks.iterator();
		Set<Bookmark> result = advert.getBookmarks();
		Iterator<Bookmark> itr2 = result.iterator();
		assertEquals(bookmarks.size(), result.size());
		while(itr.hasNext())
		{
			Bookmark expected = itr.next();
			Bookmark actual = itr2.next();
			assertEquals(expected, actual);
		}
	}
	
	@Test
	public void testSetTimeAndDateGetTimeAndDate()
	{
		Advert advert = new Advert();
		Long expected = new Date().getTime();
		advert.setTimeAndDate(expected);
		Long actual = advert.getTimeAndDate();
		assertEquals(expected, actual);
	}
}
