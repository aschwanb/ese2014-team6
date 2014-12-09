package ch.studihome.controller.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.Matchers.any;
import ch.studihome.jspserver.controller.service.AlertServiceImpl;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.SearchForm;

public class AlertServiceImplTest
{
	private AdvertDao advertDao;
	private UserDao userDao;
	private AlertServiceImpl alertServiceImpl;
	
	@Before
	public void doSetup()
	{
		advertDao = mock(AdvertDao.class);
		userDao = mock(UserDao.class);
		alertServiceImpl = new AlertServiceImpl(userDao, advertDao);
	}

	@Test
	public void testAddAlert()
	{
		SearchForm searchForm = new SearchForm();
		int minprice = 0;
		int maxprice = 1000;
		int minroomsize = 20;
		int maxroomsize = 28;
		int minappartmentsize = 100;
		int maxappartmentsize = 150;
		int minnumberofinhabitants = 1;
		int maxnumberofinhabitants = 5;
		String area = "Bern";
		String typeofapartment = "Shared Flat";
		searchForm.setMinprice(minprice);
		searchForm.setMaxprice(maxprice);
		searchForm.setMinroomsize(minroomsize);
		searchForm.setMaxroomsize(maxroomsize);
		searchForm.setMinappartmentsize(minappartmentsize);
		searchForm.setMaxappartmentsize(maxappartmentsize);
		searchForm.setMinnumberofinhabitants(minnumberofinhabitants);
		searchForm.setMaxnumberofinhabitants(maxnumberofinhabitants);
		searchForm.setArea(area);
		searchForm.setTypeofapartment(typeofapartment);
		User user = new User();
		user.setAlerts(new HashSet<Alert>());
		alertServiceImpl.addAlert(searchForm, user);
		Alert[] alerts = new Alert[0];
		alerts = user.getAlerts().toArray(alerts);
		assertEquals(1, alerts.length);
		Alert alert = alerts[0];
		assertEquals(minprice, alert.getMinprice());
		assertEquals(maxprice, alert.getMaxprice());
		assertEquals(minroomsize, alert.getMinroomsize());
		assertEquals(maxroomsize, alert.getMaxroomsize());
		assertEquals(minappartmentsize, alert.getMinappartmentsize());
		assertEquals(maxappartmentsize, alert.getMaxappartmentsize());
		assertEquals(minnumberofinhabitants, alert.getMinnumberofinhabitants());
		assertEquals(maxnumberofinhabitants, alert.getMaxnumberofinhabitants());
		assertEquals(area, alert.getArea());
		assertEquals(typeofapartment, alert.getTypeofappartment());
	}

	@Test
	public void testUpdateAlert()
	{
		when(advertDao.findFiltered(any(int.class), 
									any(int.class), 
									any(int.class), 
									any(int.class), 
									any(int.class), 
									any(int.class), 
									any(int.class), 
									any(int.class), 
									any(String.class), 
									any(Long.class))).thenAnswer(new Answer<ArrayList<Advert>>() {

			public ArrayList<Advert> answer(InvocationOnMock invocation)
					throws Throwable
			{
				ArrayList<Advert> all = new ArrayList<Advert>();
				all.add(new Advert());
				all.add(new Advert());
				all.add(new Advert());
				all.get(0).setadvId(1l);
				all.get(1).setadvId(2l);
				all.get(2).setadvId(3l);
				return all;
			}
		});
		Alert alert = new Alert();
		alert.setAdverts(new HashSet<Advert>());
		Advert[] adverts = new Advert[0];
		adverts = alert.getAdverts().toArray(adverts);
		assertEquals(0, adverts.length);
		alert.setTypeofappartment("All");
		alertServiceImpl.updateAlert(alert);
		adverts = alert.getAdverts().toArray(adverts);
		assertEquals(3, adverts.length);
	}

}
