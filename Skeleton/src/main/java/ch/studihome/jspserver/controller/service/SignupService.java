package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.User;
import ch.studihome.jspserver.model.pojos.ProfileForm;
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
    
    /**
     * @param profileForm	ProfileForm with the changed data (may become invalid, use returned ProfileForm)
     * @param user	currently logged in user (changes apply to him)
     * @return unchanged ProfileForm
     * @throws InvalidUserException thrown if the data in profileForm is invalid
     */
    public ProfileForm updateFrom(ProfileForm profileForm, User user) throws InvalidUserException;
    
    /**
     * @param password	new password to be set
     * @param user	currently logged in user (his password will be changed)
     */
    public void changePasswordFrom(String password, User user);
}
