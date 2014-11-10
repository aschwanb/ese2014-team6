package ch.studihome.model.pojos;

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

import org.junit.Test;

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
	public void testSetImgsGetImgs()
	{
		AdForm adForm = new AdForm();
		
	}

	@Test
	public void testSetImgs() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLatlng() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLatlng() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIsWG() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetIsWG() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAppartementSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetAppartementSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfRooms() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumberOfRooms() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRoomSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRoomSize() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetNumberOfInhabitants() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetNumberOfInhabitants() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetImgsCount() {
		fail("Not yet implemented");
	}

}
