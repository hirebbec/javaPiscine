package controller;

import models.User;

public class UserArrayList implements UserList {
    User[] arr;
    int size;
    int cap;

    UserArrayList() {
        this.arr = new User[10];
        this.size = 0;
        this.cap = 10;
    }

    private void resize(int newcap) {
        User[] newarr = new User[newcap];
        for (int i = 0; i < size; ++i) {
            newarr[i] = arr[i];
        }
        arr = newarr;
        cap = newcap;
    }
    @Override
    public void addUser(User user) {
        if (size == cap) {
            resize(cap * 2);
        }
        arr[size++] = user;
    }

    @Override
    public User getById(int id) {
        for(int i = 0; i < size; ++i) {
            if (arr[i].getIdetifier() == id) {
                return arr[i];
            }
        }
        throw new UserNotFoundExecption();
    }

    @Override
    public User getByIndex(int index) {
        if (index < size && index >= 0) {
            return arr[index];
        }
        throw new UserNotFoundExecption();
    }

    @Override
    public int getiSize() {
        return size;
    }
}
