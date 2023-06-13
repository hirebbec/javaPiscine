package controller;

import models.User;

public interface UserList {
    void addUser(User user);
    User getById(int id);
    User getByIndex(int index);
    int  getiSize();
}
