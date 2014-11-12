package ch.studihome.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.RegisterController;
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.SignupForm;

public class RegisterControllerTest {

		
	@Test
	public void testRegister()
	{
		RegisterController registerController = new RegisterController();
		ModelAndView model = registerController.register();
		String title = model.getViewName();
		assertEquals("register", title);
	}

	@Test
	public void testCreate()
	{
		RegisterController registerController = new RegisterController();
		SignupForm signupForm = new SignupForm();
		signupForm.setPassword("Not my Birthdate");
		signupForm.setConfirmPassword("Still not my Birthdate");
		ModelAndView model = registerController.create(signupForm, null, null);
		BSalert[] alerts = (BSalert[]) model.getModel().get("alerts");
		BSalert alert = alerts[0];
		assertEquals("Passwords not matching", alert.getMessage());
	}


}
