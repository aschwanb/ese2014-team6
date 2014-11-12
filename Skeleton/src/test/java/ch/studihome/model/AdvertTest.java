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

import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;

public class AdvertTest
{

	@Test
	public void testSetAdv_idGetAdv_id()
	{
		Advert advert = new Advert();
		long id = 122;
		advert.setAdv_id(id);
		long actual = advert.getAdv_id();
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
	public void testGetImgs()
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
	public void testIsWG()
	{
		Advert advert = new Advert();
		boolean isWG = true;
		advert.setWG(isWG);
		boolean actual = advert.isWG();
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

}
