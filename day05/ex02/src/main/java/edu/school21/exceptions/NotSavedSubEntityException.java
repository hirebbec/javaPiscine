package edu.school21.exceptions;

public class NotSavedSubEntityException extends RuntimeException{
    @Override
    public String getMessage() {
        return "NotSavedSubEntityException!";
    }
}
