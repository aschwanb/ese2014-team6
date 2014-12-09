package ch.studihome.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.MessageController;
import ch.studihome.jspserver.controller.MyAdvertsController;
import ch.studihome.jspserver.controller.service.MessageService;
import ch.studihome.jspserver.controller.service.MessageServiceImpl;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.Message;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;

public class MyAdvertsControllerTest
{
	MyUserDetailsService userService;
	MyAdvertsController myAdvertsController;
	
	
	@Before
	public void doSetup()
	{
		userService = mock(MyUserDetailsService.class);
		User user = new User();
		myAdvertsController = new MyAdvertsController(userService);
	}
	
	@Test
	public void testIndex()
	{
		when(userService.getUser()).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				HashSet<Advert> ads = new HashSet<Advert>();
				Advert ad = new Advert();
				ads.add(ad);
				user.setAds(ads);
				return user;
			}
		});
		
		ModelAndView model = myAdvertsController.index();
		User userexp = new User();
		userexp.setusrId(1l);
		HashSet<Advert> ads = new HashSet<Advert>();
		Advert ad = new Advert();
		ads.add(ad);
		userexp.setAds(ads);
		User useract = (User) model.getModel().get("user");
		assertEquals(userexp, useract);
		
		Advert adexp = new Advert();
		Advert adact = ((Advert[]) model.getModel().get("ads"))[0];
		assertEquals(adexp, adact);
	}

}
