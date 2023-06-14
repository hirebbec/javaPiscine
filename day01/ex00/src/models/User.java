package models;

public class User {
    int Idetifier;
    String Name;
    int Balance;

    public User(String name, int balance) {
        Name = name;
        Balance = balance;
        if (Balance < 0) {
            Balance = 0;
        }
    }
}
