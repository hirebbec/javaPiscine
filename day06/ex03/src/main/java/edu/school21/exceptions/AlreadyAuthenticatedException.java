package edu.school21.exceptions;

public class AlreadyAuthenticatedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "User already authenticated!";
    }
}
