package ch.studihome.controller;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.LoginController;
import ch.studihome.jspserver.model.pojos.BSalert;


public class LoginControllerTest {

	
	@Test
	public void testLogin()
	{

		LoginController loginController = new LoginController();
		ModelAndView model = loginController.login("error");
		BSalert[] alerts = (BSalert[]) model.getModel().get("alerts");
		BSalert alert = alerts[0];
		assertEquals("Invalid user name and password!", alert.getMessage());
		
	}


}
