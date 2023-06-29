package edu.school21.exceptions;

public class IllegalNumberException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Illegal number!";
    }
}
