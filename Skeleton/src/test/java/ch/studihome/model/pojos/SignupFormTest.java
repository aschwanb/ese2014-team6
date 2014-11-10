package ch.studihome.model.pojos;

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
		String email = "Not my Birthdate";
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

}
