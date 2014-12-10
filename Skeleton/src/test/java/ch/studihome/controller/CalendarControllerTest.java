package ch.studihome.controller;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.CalendarController;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.model.Bookmark;
import ch.studihome.jspserver.model.User;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalendarControllerTest
{
	MyUserDetailsService userService;
	CalendarController calendarController;
	
	@Before
	public void doSetup()
	{
		userService = mock(MyUserDetailsService.class);
		calendarController = new CalendarController(userService);
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
			return user;
		}
	});
		User expected = new User();
		expected.setusrId(1l);
		ModelAndView model = calendarController.index();
		User actual = (User) model.getModel().get("user");
		assertEquals(expected, actual);
	}

}
