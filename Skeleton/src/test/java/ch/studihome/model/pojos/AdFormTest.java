package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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
import org.springframework.web.multipart.MultipartFile;

import ch.studihome.jspserver.model.pojos.AdForm;

public class AdFormTest
{
	@Test
	public void testSetIdGetId()
	{
		AdForm adForm = new AdForm();
		long id = 2;
		adForm.setId(id);
		long actual = adForm.getId();
		assertEquals(id, actual);
	}

	@Test
	public void testSetTitleGetTitle()
	{
		AdForm adForm = new AdForm();
		String title = "An awsome title";
		adForm.setTitle(title);
		String actual = adForm.getTitle();
		assertEquals(title, actual);
	}

	@Test
	public void testSetStreetGetStreet()
	{
		AdForm adForm = new AdForm();
		String street = "Bernstrasse 11";
		adForm.setStreet(street);
		String actual = adForm.getStreet();
		assertEquals(street, actual);
	}

	@Test
	public void testSetPlzGetPlz()
	{
		AdForm adForm = new AdForm();
		String plz = "3066";
		adForm.setPlz(plz);
		String actual = adForm.getPlz();
		assertEquals(plz, actual);
	}
	
	@Test
	public void testSetCityGetCity()
	{
		AdForm adForm = new AdForm();
		String city = "Balzhausen";
		adForm.setCity(city);
		String actual = adForm.getCity();
		assertEquals(city, actual);
	}

	@Test
	public void testSetPriceGetPrice()
	{
		AdForm adForm = new AdForm();
		int price = 234;
		adForm.setPrice(price);
		int actual = adForm.getPrice();
		assertEquals(price, actual);
	}

	@Test
	public void testSetDescriptionGetDescription()
	{
		AdForm adForm = new AdForm();
		String description = "An awsome description";
		adForm.setDescription(description);
		String actual = adForm.getDescription();
		assertEquals(description, actual);
	}

	@Test
	public void testSetOwnerIdGetOwnerId()
	{
		AdForm adForm = new AdForm();
		long ownerId = 123;
		adForm.setOwnerId(ownerId);
		long actual = adForm.getOwnerId();
		assertEquals(ownerId, actual);
	}

	@Test
	public void testSetLatlngGetLatlng()
	{
		AdForm adForm = new AdForm();
		String latlng = "293483, 949743";
		adForm.setLatlng(latlng);
		String actual = adForm.getLatlng();
		assertEquals(latlng, actual);
	}

	@Test
	public void testSetIsWGGetIsWG()
	{
		AdForm adForm = new AdForm();
		boolean isWG = true;
		adForm.setIsWG(isWG);
		boolean actual = adForm.getIsWG();
		assertEquals(isWG, actual);
	}

	@Test
	public void testSetAppartementSizeGetAppartementSize()
	{
		AdForm adForm = new AdForm();
		int appartementSize = 234;
		adForm.setAppartementSize(appartementSize);
		int actual = adForm.getAppartementSize();
		assertEquals(appartementSize, actual);
	}

	@Test
	public void testSetNumberOfRoomsGetNumberOfRooms()
	{
		AdForm adForm = new AdForm();
		int numberOfRooms = 3;
		adForm.setNumberOfRooms(numberOfRooms);
		int actual = adForm.getNumberOfRooms();
		assertEquals(numberOfRooms, actual);
	}

	@Test
	public void testSetRoomSizeGetRoomSize()
	{
		AdForm adForm = new AdForm();
		int roomSize = 23;
		adForm.setRoomSize(roomSize);
		int actual = adForm.getRoomSize();
		assertEquals(roomSize, actual);
	}

	@Test
	public void testSetNumberOfInhabitantsGetNumberOfInhabitants()
	{
		AdForm adForm = new AdForm();
		int numberOfInhabitants = 4;
		adForm.setNumberOfInhabitants(numberOfInhabitants);
		int actual = adForm.getNumberOfInhabitants();
		assertEquals(numberOfInhabitants, actual);
	}

	@Test
	public void testSetImgUrlGetImgUrlGetImgsCount()
	{
		AdForm adForm = new AdForm();
		List<String> imgUrl = new ArrayList<String>();
		imgUrl.add("123");
		imgUrl.add("234");
		imgUrl.add("345");
		adForm.setImgUrl(imgUrl);
		List<String> result = adForm.getImgUrl();
		assertEquals(imgUrl.size(), result.size());
		for(int i = 0; i < imgUrl.size(); i++)
		{
			String expected = imgUrl.get(i);
			String actual = result.get(i);
			assertEquals(expected, actual);
		}
		int actual = adForm.getImgsCount();
		int expected = imgUrl.size();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetImgDescriptionGetImgDescription()
	{
		AdForm adForm = new AdForm();
		List<String> imgDescription= new ArrayList<String>();
		imgDescription.add("First awsome description");
		imgDescription.add("Second awsome description");
		imgDescription.add("Third awsome description");
		imgDescription.add("Fourth awsome description");
		adForm.setImgDescription(imgDescription);
		ArrayList<String> result = (ArrayList<String>) adForm.getImgDescription();
		assertEquals(imgDescription.size(), result.size());
		for(int i = 0; i < result.size(); i++)
		{
			String expected = imgDescription.get(i);
			String actual = result.get(i);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSetImgFileGetImgFile()
	{
		AdForm adForm = new AdForm();
		List<MultipartFile> imgFile = new ArrayList<MultipartFile>();
		adForm.setImgFile(imgFile);
		ArrayList<MultipartFile> result = (ArrayList<MultipartFile>) adForm.getImgFile();
		assertEquals(imgFile.size(), result.size());
		for(int i = 0; i < result.size(); i++)
		{
			MultipartFile expected = imgFile.get(i);
			MultipartFile actual = result.get(i);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSetImgStateGetImgState()
	{
		AdForm adForm = new AdForm();
		List<String> imgState= new ArrayList<String>();
		imgState.add("First awsome state");
		imgState.add("Second awsome state");
		imgState.add("Third awsome state");
		imgState.add("Fourth awsome state");
		adForm.setImgState(imgState);
		ArrayList<String> result = (ArrayList<String>) adForm.getImgState();
		assertEquals(imgState.size(), result.size());
		for(int i = 0; i < result.size(); i++)
		{
			String expected = imgState.get(i);
			String actual = result.get(i);
			assertEquals(expected, actual);
		}
	}

	@Test
	public void testSetImgNumberGetImgNumber()
	{
		AdForm adForm = new AdForm();
		List<String> imgNumber= new ArrayList<String>();
		imgNumber.add("1");
		imgNumber.add("2");
		imgNumber.add("3");
		imgNumber.add("4");
		adForm.setImgNumber(imgNumber);
		ArrayList<String> result = (ArrayList<String>) adForm.getImgNumber();
		assertEquals(imgNumber.size(), result.size());
		for(int i = 0; i < result.size(); i++)
		{
			String expected = imgNumber.get(i);
			String actual = result.get(i);
			assertEquals(expected, actual);
		}
	}


}
