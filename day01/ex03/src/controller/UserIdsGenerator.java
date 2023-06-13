package controller;

public class UserIdsGenerator {
    public static final UserIdsGenerator instance = new UserIdsGenerator();

    private int id = 0;
    private UserIdsGenerator() {};

    public static UserIdsGenerator getInstance() {
        return instance;
    }

    public int generateId() {
        return id++;
    }
}
