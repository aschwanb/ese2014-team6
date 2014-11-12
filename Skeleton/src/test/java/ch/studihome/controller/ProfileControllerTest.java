package ch.studihome.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashSet;
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
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.IndexController;
import ch.studihome.jspserver.controller.ProfileController;
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


public class ProfileControllerTest
{
	UserDao usrDao;
	ProfileController profileController;
	
	@Before
    public void doSetup()
    {
    	usrDao = mock(UserDao.class);
    	profileController = new ProfileController(usrDao);
    }
	
	@Test
	public void testIndex()
	{
		when(usrDao.findByEmail(any(String.class))).thenAnswer(new Answer<ArrayList<User>>() {

			public ArrayList<User> answer(InvocationOnMock invocation) throws Throwable
			{
				User user = new User();
				Set<Advert> ads = new HashSet<Advert>();
				user.setAds(ads);
				ArrayList<User> users = new ArrayList<User>();
				users.add(user);
				return users;
			}
			
		});
		
		Principal principal = mock(Principal.class);
		
		when(principal.getName()).thenAnswer(new Answer<String>() {

			public String answer(InvocationOnMock invocation) throws Throwable
			{
				return "notNull";
			}
			
		});
		
		ModelAndView model = profileController.index(principal);
		String title = model.getViewName();
		assertEquals("profile", title);
	}

}
