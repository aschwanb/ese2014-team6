package ch.studihome.model;

import static org.junit.Assert.*;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file*:src/main/webapp/WEB-INF/config/springMVC.xml",
			"file*:src/main/webapp/WEB-INF/config/springData.xml",
				"file*:src/main/webapp/WEB-INF/config/springSecurity.xml"})
//@Transactional
//@TransactionConfiguration(defaultRollback = true)
public class AdressTest {

	@Test
	public void testSetAdr_idGetAdr_id()
	{
		Address address = new Address();
		long id = 19;
		address.setAdr_id(id);
		long actual = address.getAdr_id();
		assertEquals(id, actual);
	}

	@Test
	public void testSetStreetGetStreet()
	{
		Address address = new Address();
		String street = "Huegelhackerweg 999";
		address.setStreet(street);
		String actual = address.getStreet();
		assertEquals(street, actual);
	}
	
	@Test
	public void testSetPlzGetPlz()
	{
		Address address = new Address();
		String plz = "6933";
		address.setPlz(plz);
		String actual = address.getPlz();
		assertEquals(plz, actual);
	}

	@Test
	public void testGetCity()
	{
		Address address = new Address();
		String city = "bern";
		address.setCity(city);
		String actual = address.getCity();
		assertEquals(city, actual);
	}

	@Test
	public void testSetAdvertGetAdvert()
	{
		Address address = new Address();
		Advert advert = new Advert();
		address.setAdvert(advert);
		Advert actual = address.getAdvert();
		assertEquals(advert, actual);
	}

	@Test
	public void testSetCoordinateGetCoordinate()
	{
		Address address = new Address();
		String coordinate = "123456n234567w";
		address.setCoordinate(coordinate);
		String actual = address.getCoordinate();
		assertEquals(coordinate, actual);
	}

}
