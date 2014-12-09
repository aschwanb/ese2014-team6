package ch.studihome.controller;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

import ch.studihome.jspserver.controller.AlertController;
import ch.studihome.jspserver.controller.service.AlertService;
import ch.studihome.jspserver.controller.service.MessageServiceImpl;
import ch.studihome.jspserver.controller.service.MyUserDetailsService;
import ch.studihome.jspserver.controller.service.UserService;
import ch.studihome.jspserver.model.Alert;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.MessageDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.SearchForm;

import org.mockito.invocation.InvocationOnMock;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.stubbing.Answer;
import org.springframework.web.servlet.ModelAndView;
public class AlertControllerTest
{

	AlertService alertService;
	MyUserDetailsService userService;
	AlertController alertcontroller;
	
	@Before
	public void doSetup()
	{
		alertService = mock(AlertService.class);
		userService = mock(MyUserDetailsService.class);
		alertcontroller = new AlertController(alertService, userService);
	}
	
	@Test
	public void testIndex()
	{
		when(userService.getUser()).thenAnswer(new Answer<User>() {

			public User answer(InvocationOnMock invocation) throws Throwable
			{
				User user = new User();
				user.setusrId(1l);
				HashSet<Alert> alerts = new HashSet<Alert>();
				Alert alert = new Alert();
				alerts.add(alert);
				user.setAlerts(alerts);
				return user;
			}
			
		});
		User expected = new User();
		expected.setusrId(1l);
		HashSet<Alert> alerts = new HashSet<Alert>();
		Alert alert = new Alert();
		alerts.add(alert);
		expected.setAlerts(alerts);
		
		ModelAndView model = alertcontroller.index();
		User actual = (User) model.getModel().get("user");
		assertEquals(expected, actual);
	}

	@Test
	public void testSetAlert()
	{
		SearchForm searchForm = new SearchForm();
		ModelAndView model = alertcontroller.setAlert(searchForm);
		String expected = "success";
		String actual = (String) model.getModel().get("content");
		assertEquals(expected, actual);
	}

}
