package ch.studihome.controller;

import java.util.ArrayList;

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
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.IndexController;
import ch.studihome.jspserver.controller.service.AdService;
import ch.studihome.jspserver.controller.service.AdServiceImpl;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.controller.service.SignupServiceImpl;
import ch.studihome.jspserver.model.Address;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.RoomImg;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.RoomImgDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import ch.studihome.jspserver.model.pojos.SignupForm;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Before;

public class IndexControllerTest {

	private AdService adService;
    private IndexController indexController;
	
	@Before
    public void doSetup()
    {
    	adService = mock(AdServiceImpl.class);
    	indexController = new IndexController(adService);
    }
	
	@Test
	public void testIndex()
	{
		when(adService.findAll()).thenAnswer(new Answer<ArrayList<Advert>>(){

			public ArrayList<Advert> answer(InvocationOnMock invocation)
					throws Throwable
			{
				ArrayList<Advert> ads = new ArrayList<Advert>();
				Advert advert = new Advert();
				advert.setadvId(1l);
				ads.add(advert);
				return ads;
			}
			
		});
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView = indexController.index();
		ArrayList<Advert> ads = (ArrayList<Advert>) modelAndView.getModel().get("ads");
		assertNotNull(ads.size());
		assertTrue(ads.size() > 0);
		Advert advert = ads.get(0);
		assertEquals(advert.getadvId(), new Long(1));
	}

}
