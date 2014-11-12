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

import ch.studihome.jspserver.controller.AdvertController;
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
		assertEquals("Advert - Error 404", title);
		
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
