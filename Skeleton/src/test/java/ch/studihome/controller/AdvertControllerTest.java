package ch.studihome.controller;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.AdvertController;
import ch.studihome.jspserver.controller.service.AdServiceImpl;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.AdForm;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Before;

public class AdvertControllerTest
{
	AdvertDao advDao;
	UserDao usrDao;
	AdServiceImpl adService;
	AdvertController advertController;
	
	@Before
    public void doSetup()
    {
    	adService = mock(AdServiceImpl.class);
    	usrDao = mock (UserDao.class);
    	advDao = mock(AdvertDao.class);
    	advertController = new AdvertController(adService, usrDao, advDao);
    }
	
	@Test
	public void testShow()
	{
		ModelAndView model = advertController.show(null, null);
		String title = (String) model.getModel().get("title");
		assertEquals("Advert - Error 403", title);
		
		when(adService.loadById(any(String.class))).thenAnswer(new Answer<AdForm>() {

			public AdForm answer(InvocationOnMock invocation) throws Throwable
			{
				return null;
			}
			
		});
		
		model = advertController.show("1", null);
		title = (String) model.getModel().get("title");
		assertEquals("Advert - Error 404", title);
		
		
	}

	@Test
	public void testSave()
	{
		AdForm adForm = new AdForm();
		adForm.setTitle("title");
		ModelAndView model = advertController.save(adForm, null, null, null);
		String title = (String) model.getModel().get("title");
		assertEquals("Access denied!", title);
	}

}
