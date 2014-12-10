package ch.studihome.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.ProfileController;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.controller.service.SignupService;
import ch.studihome.jspserver.controller.service.SignupServiceImpl;
import ch.studihome.jspserver.model.Advert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.ProfileForm;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Before;


public class ProfileControllerTest
{
	UserDao usrDao;
	SignupService signupService;
	MyUserDetailsService userService;
	ProfileController profileController;
	
	@Before
    public void doSetup()
    {
		usrDao = mock(UserDao.class);
		userService = mock(MyUserDetailsService.class);
		signupService = mock(SignupServiceImpl.class);
    	profileController = new ProfileController(usrDao, signupService, userService);
    	
    	User user = new User();
        /* fill user object here (if needed) */

        Authentication auth = new UsernamePasswordAuthenticationToken(user,null);

        SecurityContextHolder.getContext().setAuthentication(auth);
    }
	
	@Test
	public void testIndex()
	{
		when(userService.getUser()).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation) throws Throwable
			{
				User user = new User();
				user.setEmail("email");
				user.setFirstName("firstName");
				user.setLastName("lastName");
				return user;
			}
			
		});
		
		ModelAndView model = profileController.index(null, null);
		String title = model.getViewName();
		assertEquals("profile", title);
		
	}

}
