package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.pojos.SignupForm;

/**
 * Responsible to save new User data into DB
 * 
 * @author teamSiX
 */
public interface SignupService {

	/**
	 * @param signupForm SignupForm with the data to be saved (may become invalid, use returned SignupForm)
	 * @return unchanged SignupForm
	 * @throws InvalidUserException thrown if the data in signupForm is invalid
	 */
    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
