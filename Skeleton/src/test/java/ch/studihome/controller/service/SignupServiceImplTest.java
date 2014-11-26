package ch.studihome.controller.service;

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

import ch.studihome.jspserver.controller.service.AdServiceImpl;
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

public class SignupServiceImplTest
{
	private UserDao userDao;
    private AddressDao addDao;
    private SignupServiceImpl signupServiceImpl;
    @Before
    public void doSetup()
    {
    	userDao = mock(UserDao.class);
    	addDao = mock(AddressDao.class);
    	signupServiceImpl = new SignupServiceImpl(userDao, addDao);
    }
    
	@Test
	public void testSaveFrom()
	{
		when(userDao.save(any(User.class))).thenAnswer(new Answer<User> () {

			public User answer(InvocationOnMock invocation) throws Throwable
			{
				User user = (User) invocation.getArguments()[0];
				user.setusrId(1L);
				return user;
			}
			
		});
		
		SignupForm signupForm = new SignupForm();
		assertNull(signupForm.getId());
		signupForm = signupServiceImpl.saveFrom(signupForm);
		assertNotNull(signupForm.getId());
		assertTrue(signupForm.getId() > 0);
	}

}
