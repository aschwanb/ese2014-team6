package org.studihome.controller.exceptions;

public class InvalidUserException extends RuntimeException {

    public InvalidUserException(String s) {
        super(s);
    }
}
