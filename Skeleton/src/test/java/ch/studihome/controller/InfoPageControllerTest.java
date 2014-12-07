package ch.studihome.controller;

import org.junit.Test;

import static org.junit.Assert.*;

import org.springframework.web.servlet.ModelAndView;

import ch.studihome.jspserver.controller.InfoPageController;
import ch.studihome.jspserver.model.pojos.BSalert;
public class InfoPageControllerTest
{

	@Test
	public void testNoAccess()
	{
		InfoPageController infoPageController = new InfoPageController();
		ModelAndView modelAndView = infoPageController.noAccess(null);
		BSalert[] alerts = (BSalert[]) modelAndView.getModel().get("alerts");
		BSalert alert = alerts[0];
		assertEquals(alert.getMessage(), "You don't have the permission to access this page.");
	}

}
