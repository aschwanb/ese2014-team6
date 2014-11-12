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

import ch.studihome.jspserver.controller.IndexController;
import ch.studihome.jspserver.controller.LoginController;
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
import ch.studihome.jspserver.model.pojos.BSalert;
import ch.studihome.jspserver.model.pojos.SignupForm;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.Before;


public class LoginControllerTest {

	
	@Test
	public void testLogin()
	{

		LoginController loginController = new LoginController();
		ModelAndView model = loginController.login("error");
		BSalert[] alerts = (BSalert[]) model.getModel().get("alerts");
		BSalert alert = alerts[0];
		assertEquals("Invalid email and password!", alert.getMessage());
		
	}


}
