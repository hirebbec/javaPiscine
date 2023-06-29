package edu.school21.exceptions;

public class EntityNotFoundException extends RuntimeException {
    @Override
    public String getMessage() {
        return "User Not Found!";
    }
}
