package ch.studihome.jspserver.controller.service;

import ch.studihome.jspserver.controller.exceptions.InvalidUserException;
import ch.studihome.jspserver.model.pojos.SignupForm;

public interface SignupService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
