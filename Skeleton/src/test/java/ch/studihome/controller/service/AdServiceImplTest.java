package ch.studihome.controller.service;

import java.util.ArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

import ch.studihome.jspserver.controller.service.AdServiceImpl;
import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.RoomImgDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;




import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;


import org.junit.Before;

public class AdServiceImplTest
{

	private AdvertDao advertDao;
	private UserDao usrDao;
	private RoomImgDao rimgDao;
	private AdServiceImpl adServiceImpl;
	
	@Before
	public void doSetup()
	{
		advertDao = mock(AdvertDao.class);
		usrDao = mock(UserDao.class);
		rimgDao = mock(RoomImgDao.class);
		adServiceImpl = new AdServiceImpl(advertDao, usrDao, rimgDao);
	}
	
	@Test
	public void testFindAll()
	{
		when(advertDao.findAll()).thenAnswer(new Answer<ArrayList<Advert>>() {

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
		
		ArrayList<Advert> all = (ArrayList<Advert>) adServiceImpl.findAll();
		assertNotNull(all.get(0).getadvId());
		assertNotNull(all.get(1).getadvId());
		assertNotNull(all.get(2).getadvId());
		

		assertTrue(all.get(0).getadvId() > 0);
		assertTrue(all.get(1).getadvId() > 0);
		assertTrue(all.get(2).getadvId() > 0);
	}

	@Test
	public void testLoadById()
	{
		when(advertDao.findOne(any(Long.class))).thenAnswer(new Answer<Advert> (){

			public Advert answer(InvocationOnMock invocation) throws Throwable
			{
				Advert advert = new Advert();
				advert.setadvId(2L);
				advert.setAddress(new Address());
				User user = new User();
				user.setusrId(1L);
				advert.setUser(user);
				return advert;
			}
			
		});
		
		AdForm adForm = adServiceImpl.loadById("2");
		assertNotNull(adForm.getId());
		assertTrue(adForm.getId() > 0);
	}

	@Test
	public void testSaveFrom()
	{
		
		when(advertDao.save(any(Advert.class))).thenAnswer(new Answer<Advert>() {

			public Advert answer(InvocationOnMock invocation) throws Throwable
			{
				Advert advert = (Advert) invocation.getArguments()[0];
				advert.setadvId(2L);
				return advert;
			}
			
		});
		
		AdForm adForm = new AdForm();
			
		
		assertEquals(adForm.getId(), 0);
		adForm = adServiceImpl.saveFrom(adForm);
		
		assertNotNull(adForm.getId());
		assertTrue(adForm.getId() > 0);
	}

}
