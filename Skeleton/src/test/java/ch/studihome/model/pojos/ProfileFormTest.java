package ch.studihome.model.pojos;

import static org.junit.Assert.*;

import org.junit.Test;

import ch.studihome.jspserver.model.pojos.ProfileForm;

public class ProfileFormTest
{

	@Test
	public void testSetFistNameGetFirstName()
	{
		ProfileForm profileForm = new ProfileForm();
		String firstName = "Hans";
		profileForm.setFirstName(firstName);
		String actual = profileForm.getFirstName();
		assertEquals(firstName, actual);
	}

	@Test
	public void testSetLastNameGetLastName()
	{
		ProfileForm profileForm = new ProfileForm();
		String lastName = "Meier";
		profileForm.setLastName(lastName);
		String actual = profileForm.getLastName();
		assertEquals(lastName, actual);
	}

	@Test
	public void testSetEmailGetEmail()
	{
		ProfileForm profileForm = new ProfileForm();
		String email = "h.meier@test.com";
		profileForm.setEmail(email);
		String actual = profileForm.getEmail();
		assertEquals(email, actual);
	}

}
