package ch.studihome.model.pojos;

import org.junit.Test;

import static org.junit.Assert.*;

import ch.studihome.jspserver.model.pojos.SignupForm;


public class SignupFormTest {

	@Test
	public void testSetPasswordGetPassword()
	{
		SignupForm signupForm = new SignupForm();
		String password = "Not my Birthdate";
		signupForm.setPassword(password);
		String actual = signupForm.getPassword();
		assertEquals(password, actual);
	}

	@Test
	public void testSetEmailGetEmail()
	{
		SignupForm signupForm = new SignupForm();
		String email = "test@test.com";
		signupForm.setEmail(email);
		String actual = signupForm.getEmail();
		assertEquals(email, actual);
	}

	@Test
	public void testSetIdGetId()
	{
		SignupForm signupForm = new SignupForm();
		long id = 123;
		signupForm.setId(id);
		long actual = signupForm.getId();
		assertEquals(id, actual);
	}

	@Test
	public void testSetConfirmPasswordGetConfirmPassword()
	{
		SignupForm signupForm = new SignupForm();
		String confirmPassword = "Still not my Birthdate";
		signupForm.setConfirmPassword(confirmPassword);
		String actual = signupForm.getConfirmPassword();
		assertEquals(confirmPassword, actual);
	}

	@Test
	public void testSetFirstNameGetFirstName()
	{
		SignupForm signupForm = new SignupForm();
		String expected = "Hans";
		signupForm.setFirstName(expected);
		String actual = signupForm.getFirstName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetLastNameGetLastName()
	{
		SignupForm signupForm = new SignupForm();
		String expected = "Muster";
		signupForm.setLastName(expected);
		String actual = signupForm.getLastName();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSetUserNameGetUserName()
	{
		SignupForm signupForm = new SignupForm();
		String expected = "Batman";
		signupForm.setUserName(expected);
		String actual = signupForm.getUserName();
		assertEquals(expected, actual);
	}
}
