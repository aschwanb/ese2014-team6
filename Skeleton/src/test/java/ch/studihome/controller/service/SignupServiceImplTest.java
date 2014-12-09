package ch.studihome.controller.service;

import org.junit.Test;

import static org.junit.Assert.*;
import ch.studihome.jspserver.controller.service.SignupServiceImpl;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.dao.AddressDao;
import ch.studihome.jspserver.model.dao.UserDao;
import ch.studihome.jspserver.model.pojos.ProfileForm;
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
	
	@Test
	public void testUpdateFrom()
	{
		ProfileForm profileForm = new ProfileForm();
		profileForm.setEmail("email");
		profileForm.setFirstName("firstName");
		profileForm.setLastName("lastName");
		
		User user = new User();
		
		signupServiceImpl.updateFrom(profileForm, user);
		
		when(userDao.save(any(User.class))).thenAnswer(new Answer<User> () {

			public User answer(InvocationOnMock invocation) throws Throwable
			{
				User user = (User) invocation.getArguments()[0];
				assertEquals("email", user.getEmail());
				assertEquals("firstName", user.getFirstName());
				assertEquals("lastName", user.getLastName());
				return user;
			}
			
		});
	}
	
	@Test
	public void testChangePasswordFrom()
	{
		String password = "password1";
		User user = new User();
		user.setPassword(password);
		assertEquals(password, user.getPassword());
		password = "password2";
		signupServiceImpl.changePasswordFrom(password, user);
		
		when(userDao.save(any(User.class))).thenAnswer(new Answer<User> () {

			public User answer(InvocationOnMock invocation) throws Throwable
			{
				User user = (User) invocation.getArguments()[0];
				assertEquals("password2", user.getPassword());
				return user;
			}
			
		});
	}

}
