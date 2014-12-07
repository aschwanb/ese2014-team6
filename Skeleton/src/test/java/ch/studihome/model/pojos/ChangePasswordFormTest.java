package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.pojos.ChangePasswordForm;

public class ChangePasswordFormTest
{

	@Test
	public void testSetPasswordGetPassword()
	{
		ChangePasswordForm changePasswordForm = new ChangePasswordForm();
		String expected = "notMyBirthdate";
		changePasswordForm.setPassword(expected);
		String actual = changePasswordForm.getPassword();
		assertEquals(expected, actual);
	}

	@Test
	public void testSetConfirmPasswordGetConfirmPassword()
	{
		ChangePasswordForm changePasswordForm = new ChangePasswordForm();
		String expected = "stillnotMyBirthdate";
		changePasswordForm.setConfirmPassword(expected);
		String actual = changePasswordForm.getConfirmPassword();
		assertEquals(expected, actual);
	}

}
