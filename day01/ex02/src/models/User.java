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

    public int getIdetifier() {
        return Idetifier;
    }

    public String getName() {
        return Name;
    }

    public int getBalance() {
        return Balance;
    }
}
