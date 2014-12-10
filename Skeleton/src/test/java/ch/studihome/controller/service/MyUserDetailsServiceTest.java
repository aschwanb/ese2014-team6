package ch.studihome.controller.service;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import ch.studihome.jspserver.controller.service.InviteServiceImpl;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AdvertDao;
import ch.studihome.jspserver.model.dao.InviteDao;
import ch.studihome.jspserver.model.dao.UserDao;

public class MyUserDetailsServiceTest
{
	private UserDao userDao;
	private MyUserDetailsService myUserDetailsService;
	
	@Before
	public void doSetup()
	{
		userDao = mock(UserDao.class);
		myUserDetailsService = new MyUserDetailsService(userDao);
		User user = new User();
		user.setUserName("hans");
		Authentication auth = new UsernamePasswordAuthenticationToken(user,null);

        SecurityContextHolder.getContext().setAuthentication(auth);
	}
//	@Test
//	public void testLoadUserByUsername()
//	{
//		//add future Test
////		fail("Test not yet implemented");
//	}

	@Test
	public void testGetUser()
	{
		when(userDao.findByUserName(any(String.class))).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation)
					throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				user.setFirstName("firstName");
				user.setLastName("lastName");
				user.setUserName("userName");
				user.setEmail("email");
				user.setPassword("password");
				user.setUser_role("user_role");
				user.setEnabled("enabled");
				return user;
			}
		});
		
		User expected = new User();
		expected.setusrId(1l);
		
		
        
        User actual = myUserDetailsService.getUser();
	}

}
