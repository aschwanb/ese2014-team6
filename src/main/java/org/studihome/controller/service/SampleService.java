package org.studihome.controller.service;

import org.studihome.controller.exceptions.InvalidUserException;
import org.studihome.controller.pojos.SignupForm;

public interface SampleService {

    public SignupForm saveFrom(SignupForm signupForm) throws InvalidUserException;

}
