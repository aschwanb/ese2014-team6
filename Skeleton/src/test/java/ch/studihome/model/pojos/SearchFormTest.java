package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.Test;

import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.SearchForm;

public class SearchFormTest
{

	@Test
	public void testSetAlertIdGetAlertId()
	{
		SearchForm searchForm = new SearchForm();
		long expected = 1l;
		searchForm.setId(expected);
		long actual = searchForm.getId();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinpriceGetMinprice()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 100;
		searchForm.setMinprice(expected);
		int actual = searchForm.getMinprice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxpriceGetMaxprice()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 1000;
		searchForm.setMaxprice(expected);
		int actual = searchForm.getMaxprice();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinroomsizeGetMinroomsize()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 20;
		searchForm.setMinroomsize(expected);
		int actual = searchForm.getMinroomsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxroomsizeGetMaxroomsize()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 25;
		searchForm.setMaxroomsize(expected);
		int actual = searchForm.getMaxroomsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMinappartmentsizeGetMinappartmentsize()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 200;
		searchForm.setMinappartmentsize(expected);
		int actual = searchForm.getMinappartmentsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxappartmentsizeGetMaxappartmentsize()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 250;
		searchForm.setMaxappartmentsize(expected);
		int actual = searchForm.getMaxappartmentsize();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetminnumberofinhabitantsGetMinnumberofinhabitants()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 2;
		searchForm.setMinnumberofinhabitants(expected);
		int actual = searchForm.getMinnumberofinhabitants();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetMaxnumberofinhabitantsGetMaxnumberofinhabitants()
	{
		SearchForm searchForm = new SearchForm();
		int expected = 5;
		searchForm.setMaxnumberofinhabitants(expected);
		int actual = searchForm.getMaxnumberofinhabitants();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAreaGetArea()
	{
		SearchForm searchForm = new SearchForm();
		String expected = "Bern";
		searchForm.setArea(expected);
		String actual = searchForm.getArea();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetTypeofappartmentGetTypeofappartment()
	{
		SearchForm searchForm = new SearchForm();
		String expected = "Shared Flat";
		searchForm.setTypeofapartment(expected);
		String actual = searchForm.getTypeofapartment();
		assertEquals(expected, actual);
	}

}
