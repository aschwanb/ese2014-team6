package org.sample.controller.service;

import org.sample.controller.exceptions.InvalidUserException;
import org.sample.model.pojos.SignupForm;

public interface SignupService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
