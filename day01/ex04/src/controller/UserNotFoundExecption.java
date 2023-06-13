package controller;

public class UserNotFoundExecption extends RuntimeException {
    @Override
    public String getMessage() {
        return "User not Found!\n";
    }
}
